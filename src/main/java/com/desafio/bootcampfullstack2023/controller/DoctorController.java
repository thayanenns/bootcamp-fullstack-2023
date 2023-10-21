package com.desafio.bootcampfullstack2023.controller;

import com.desafio.bootcampfullstack2023.domain.model.Doctor;
import com.desafio.bootcampfullstack2023.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final DoctorService doctorService;

    public DoctorController (DoctorService doctorService){
        this.doctorService = doctorService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable Long id){
        var doctor = doctorService.findById(id);
        return ResponseEntity.ok(doctor);
    }

    @PostMapping
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctorToCreate){
        var doctorCreated = doctorService.create(doctorToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(doctorCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(doctorCreated);
    }
}

