package com.mediscreen.mspatientadmin.controller;

import com.mediscreen.mspatientadmin.exception.NotFoundException;
import com.mediscreen.mspatientadmin.interfaces.PatientServiceInterface;
import com.mediscreen.mspatientadmin.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientServiceInterface patientService;

    @GetMapping("/patient/getAll")
    public List<Patient> getPatient() {
        List<Patient> patientList = patientService.getAllPatient();
        if (patientList == null) throw new NotFoundException("No data found");
        return patientList;
    }

    @GetMapping("/patient/get/{id}")
    public Patient getPatient(@PathVariable int id) {
        Patient patient = patientService.getPatientById(id);
        if (patient == null) throw new NotFoundException("Unknown patient with id : " + id);
        return patient;
    }

    @PostMapping("/patient/create")
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient){
        Patient newPatient = patientService.createPatient(patient);
        if (newPatient == null) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(newPatient, HttpStatus.CREATED);
    }

    @PutMapping("/patient/update")
    public ResponseEntity<Patient> updatePatient(@Valid @RequestBody Patient patient){
        Patient updatedPatient = patientService.updatePatient(patient);
        if (updatedPatient == null) return ResponseEntity.noContent().build();
        return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
    }

    @DeleteMapping("/patient/delete/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable int id){
        if (!patientService.deletePatientById(id)) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().build();
    }
}
