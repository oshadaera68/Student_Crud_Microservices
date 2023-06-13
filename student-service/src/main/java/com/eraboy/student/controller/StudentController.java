package com.eraboy.student.controller;

import com.eraboy.StudentCrud.entity.Student;
import com.eraboy.StudentCrud.service.custom.StudentService;
import com.eraboy.StudentCrud.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllStudents() {
        return new ResponseUtil(200, "ok", studentService.getAllStudents());
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return new ResponseUtil(200, "Saved Student", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return new ResponseUtil(200, "update student", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchStudent(@PathVariable long id) {
        return new ResponseUtil(200, "OK", studentService.searchStudent(id));
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteStudent(@RequestParam long id) {
        studentService.deleteStudent(id);
        return new ResponseUtil(200, "Deleted", null);
    }
}
