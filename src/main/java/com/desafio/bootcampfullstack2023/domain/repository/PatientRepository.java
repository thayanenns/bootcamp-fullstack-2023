package com.desafio.bootcampfullstack2023.domain.repository;

import com.desafio.bootcampfullstack2023.domain.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
