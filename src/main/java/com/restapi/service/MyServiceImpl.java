package com.restapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.restapi.model.Patient;
import com.restapi.model.PatientId;
import com.restapi.repository.MyRepository;
import com.restapi.repository.PatientIdRepository;

//import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {
    private MyRepository myRepository;
    private PatientIdRepository pidRepository;

    @Autowired
    public MyServiceImpl(MyRepository myRepository, PatientIdRepository pidRepository) {
        this.myRepository = myRepository;
        this.pidRepository = pidRepository;
    }

    @Override
    public List<Patient> getByFnameAndLname(String name) {
        List<Patient> patients = new ArrayList<>();
        myRepository.getByFnameAndLname(name).forEach(patients::add);
        return patients;
    }

    @Override
    public List<Patient> listAll() {
        List<Patient> patients = new ArrayList<>();
        myRepository.findAll().forEach(patients::add);
        return patients;
    }

    /*
     * @Override public Patient saveOrUpdate(Patient patient) {
     * patient.setPid(RandomStringUtils.randomAlphanumeric(16));
     * myRepository.save(patient); return patient; }
     */
    @Override
    public Optional<Patient> getByPid(String pid) {
        return myRepository.findById(pid);
    }

    @Override
    public String saveOrUpdate(String pid) {
        PatientId patientId = new PatientId(pid);
        System.out.println("startservice");
        pidRepository.save(patientId);
        System.out.println("endservice");
        return "idsaved";
    }

    
    
}