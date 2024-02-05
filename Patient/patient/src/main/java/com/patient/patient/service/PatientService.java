package com.patient.patient.service;
import com.patient.patient.enitity.Patient;

import java.util.List;


public interface PatientService {
    Patient createPatient(Patient patient);

    List<Patient> getAllPatient();

    Patient getByPatientId(long id);

    Patient updatePatient(Patient patient);

    void deletePatient(long id);
}
