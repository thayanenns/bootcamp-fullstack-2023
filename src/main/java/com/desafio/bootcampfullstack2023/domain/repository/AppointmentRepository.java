package com.desafio.bootcampfullstack2023.domain.repository;

import com.desafio.bootcampfullstack2023.domain.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
