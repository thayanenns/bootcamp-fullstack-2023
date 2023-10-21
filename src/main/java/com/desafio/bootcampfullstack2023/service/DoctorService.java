package com.desafio.bootcampfullstack2023.service;

import com.desafio.bootcampfullstack2023.domain.model.Doctor;
import com.desafio.bootcampfullstack2023.domain.model.Patient;

public interface DoctorService {

    Doctor findById(Long id);

    Doctor create(Doctor doctorToCreate);
}
