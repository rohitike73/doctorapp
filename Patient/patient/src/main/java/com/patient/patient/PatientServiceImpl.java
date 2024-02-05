package com.patient.patient.service.impl;
import com.patient.patient.enitity.Patient;
import com.patient.patient.repository.PatientRepository;
import com.patient.patient.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository=patientRepository;
    }
    @Override
    public Patient createPatient(Patient patient) {
        Patient patiententity = patientRepository.save(patient);
        return patiententity;
    }

    @Override
    public List<Patient> getAllPatient() {
        List<Patient> patients = patientRepository.findAll();
        return patients;
    }

    @Override
    public Patient getByPatientId(long id) {
        Optional<Patient> byId = patientRepository.findById(id);
        Patient patient = byId.get();
        return patient;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        Patient patient1 = patientRepository.save(patient);
        return patient1;
    }

    @Override
    public void deletePatient(long id) {
        patientRepository.deleteById(id);
    }
}
