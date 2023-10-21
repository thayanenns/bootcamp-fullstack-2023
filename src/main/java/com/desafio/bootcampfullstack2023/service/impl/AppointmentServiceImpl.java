package com.desafio.bootcampfullstack2023.service.impl;

import com.desafio.bootcampfullstack2023.domain.model.Appointment;
import com.desafio.bootcampfullstack2023.domain.repository.AppointmentRepository;
import com.desafio.bootcampfullstack2023.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Appointment findById(Long id) {
        return appointmentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Appointment create(Appointment appointmentToCreate) {
        if (appointmentToCreate.getId() != null && appointmentRepository.existsById(appointmentToCreate.getId())) {
            throw new IllegalArgumentException("This doctor ID already exists.");
        }
        return appointmentRepository.save(appointmentToCreate);
    }
}
