package com.example.diploma.controller;

import com.example.diploma.entity.Diploma;
import com.example.diploma.service.custom.DiplomaService;
import com.example.diploma.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/diploma")
@CrossOrigin
public class DiplomaController {
    @Autowired
    private DiplomaService diplomaService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDiplomas() {
        return new ResponseUtil(200, "ok", diplomaService.getAllDiplomas());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseUtil saveDiploma(@RequestBody Diploma d) {
        diplomaService.saveDiploma(d);
        return new ResponseUtil(200, "Saved diploma", null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDiploma(@RequestBody Diploma d) {
        diplomaService.updateDiploma(d);
        return new ResponseUtil(200, "update diploma", null);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDiploma(@PathVariable long id) {
        return new ResponseUtil(200, "OK", diplomaService.searchDiploma(id));
    }

    @DeleteMapping(params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deleteDiploma(@RequestParam long id) {
        diplomaService.deleteDiploma(id);
        return new ResponseUtil(200, "Deleted", null);
    }
}
