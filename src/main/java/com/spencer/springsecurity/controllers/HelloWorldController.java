package com.spencer.springsecurity.controllers;


import com.spencer.springsecurity.entities.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String hello(HttpServletRequest request)
    {
        return "Hello World"+" Your session ID is : "+request.getSession().getId();
    }

    List<Student> students=new ArrayList<>(
            List.of(
                    new Student(90,"1","Spencer"),
                    new Student(80,"2","John"),
                    new Student(70,"3","Jane"),
                    new Student(60,"4","Bob"),
                    new Student(50,"5","Alice")
            )
    );

    /*
    * What is CSRF (Cross-Site Request Forgery)?
    * CSRF is a type of attack where a malicious website tricks a user's browser into
    * performing actions on another website where the user is authenticated. For example, if
    * a user is logged into their bank account and visits a malicious website, that website
    * could send a request to the bank's website to transfer money without the user's knowledge.
    *
    *
    * */

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return students;
    }

    @PostMapping("/students")
    public ResponseEntity<Student> addStudent(@RequestBody Student student)
    {
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/csrf")
    public ResponseEntity<CsrfToken> getCsrfToken(HttpServletRequest request)
    {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        return ResponseEntity.ok(csrfToken);
    }

    public ResponseEntity<Student> addStudentAuto(@RequestBody Student student)
    {
        // how can I build a post request itself in the controller?
        // and the fire the request from here?
        // also find out why everytime a try to get the csrf token, I get a new token ?



        return  ResponseEntity.status(HttpStatus.CREATED).body(student);

    }


}
