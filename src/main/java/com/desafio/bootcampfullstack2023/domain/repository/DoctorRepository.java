package com.desafio.bootcampfullstack2023.domain.repository;

import com.desafio.bootcampfullstack2023.domain.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
