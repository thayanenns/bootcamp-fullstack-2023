package com.desafio.bootcampfullstack2023.controller;

import com.desafio.bootcampfullstack2023.domain.model.Appointment;
import com.desafio.bootcampfullstack2023.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController (AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> findById(@PathVariable Long id){
        var appointment = appointmentService.findById(id);
        return ResponseEntity.ok(appointment);
    }

    @PostMapping
    public ResponseEntity<Appointment> create(@RequestBody Appointment appointmentToCreate){
        var appointmentCreated = appointmentService.create(appointmentToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(appointmentCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(appointmentCreated);
    }
}
