package com.desafio.bootcampfullstack2023.controller;

import com.desafio.bootcampfullstack2023.domain.model.Patient;
import com.desafio.bootcampfullstack2023.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController (PatientService patientService){
        this.patientService = patientService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Long id){
        var patient = patientService.findById(id);
        return ResponseEntity.ok(patient);
    }

    @PostMapping
    public ResponseEntity<Patient> create(@RequestBody Patient patientToCreate){
        var patientCreated = patientService.create(patientToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(patientCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(patientCreated);
    }
}
