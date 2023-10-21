package com.desafio.bootcampfullstack2023.service;

import com.desafio.bootcampfullstack2023.domain.model.Appointment;

public interface AppointmentService {

    Appointment findById(Long id);

    Appointment create(Appointment appointmentToCreate);
}
