package com.desafio.bootcampfullstack2023.service.impl;

import com.desafio.bootcampfullstack2023.domain.model.Doctor;
import com.desafio.bootcampfullstack2023.domain.repository.DoctorRepository;
import com.desafio.bootcampfullstack2023.domain.repository.PatientRepository;
import com.desafio.bootcampfullstack2023.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository){
        this.doctorRepository = doctorRepository;
    }
    @Override
    public Doctor findById(Long id) {
        return doctorRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Doctor create(Doctor doctorToCreate) {
        if(doctorToCreate.getId() != null && doctorRepository.existsById(doctorToCreate.getId())){
            throw new IllegalArgumentException("This doctor ID already exists.");
        }
        return doctorRepository.save(doctorToCreate);    }
}
