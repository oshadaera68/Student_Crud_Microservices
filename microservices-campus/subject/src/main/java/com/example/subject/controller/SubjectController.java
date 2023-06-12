package com.example.subject.controller;

import com.example.diploma.util.ResponseUtil;
import com.example.subject.service.custom.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;

@RestController
@RequestMapping("/subject")
@CrossOrigin
public class SubjectController {
    @Autowired
    private SubjectService subjectService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllSubjects() {
        return new ResponseUtil(200, "ok", subjectService.getAllSubjects());
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil saveSubject(@RequestBody com.example.subject.entity.Subject subject) {
        subjectService.saveSubject(subject);
        return new ResponseUtil(200, "Saved subject", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateSubject(@RequestBody com.example.subject.entity.Subject subject) {
        subjectService.updateSubject(subject);
        return new ResponseUtil(200, "update subject", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchSubject(@PathVariable long id) {
        return new ResponseUtil(200, "OK", subjectService.searchSubject(id));
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteSubject(@RequestParam long id) {
        subjectService.deleteSubject(id);
        return new ResponseUtil(200, "Deleted", null);
    }
}
