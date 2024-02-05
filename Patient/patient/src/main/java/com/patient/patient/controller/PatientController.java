package com.patient.patient.controller;
import com.patient.patient.enitity.Patient;
import com.patient.patient.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    private PatientService patientService;
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient){
        Patient patient1 = patientService.createPatient(patient);
        return new ResponseEntity<>(patient1, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Patient> getAllPatient(){
        List<Patient> allPatient = patientService.getAllPatient();
        return allPatient;
    }

    @GetMapping("{id}")
    public ResponseEntity<Patient> getByPatientId(@PathVariable("id")long id){
        Patient patient = patientService.getByPatientId(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient){
        Patient patient1 = patientService.updatePatient(patient);
        return new ResponseEntity<>(patient1, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") long id){
        patientService.deletePatient(id);
        return new ResponseEntity<>("Patient id deleted", HttpStatus.OK);
    }
}