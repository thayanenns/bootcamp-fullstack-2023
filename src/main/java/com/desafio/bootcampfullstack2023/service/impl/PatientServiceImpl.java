package com.desafio.bootcampfullstack2023.service.impl;

import com.desafio.bootcampfullstack2023.domain.model.Patient;
import com.desafio.bootcampfullstack2023.domain.repository.PatientRepository;
import com.desafio.bootcampfullstack2023.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }
    @Override
    public Patient findById(Long id) {
        return patientRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Patient create(Patient patientToCreate) {
        if(patientToCreate.getId() != null && patientRepository.existsById(patientToCreate.getId())){
            throw new IllegalArgumentException("This patient ID already exists.");
        }
        return patientRepository.save(patientToCreate);
    }
}
