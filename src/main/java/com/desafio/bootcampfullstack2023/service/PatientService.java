package com.desafio.bootcampfullstack2023.service;

import com.desafio.bootcampfullstack2023.domain.model.Patient;

public interface PatientService {

    Patient findById(Long id);

    Patient create(Patient patientToCreate);


}
