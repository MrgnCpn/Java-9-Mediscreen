package com.mediscreen.msclientui.interfaces;

import com.mediscreen.msclientui.models.Patient;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientServiceInterface {

    /**
     * Get patient by id from ms-patientAdmin
     * @param token
     * @return
     */
    List<Patient> getAllPatients(String token);

    /**
     * Get All patients from ms-patientAdmin
     * @param token
     * @param id
     * @return
     */
    Patient getPatient(String token, int id);

    /**
     * Create patient to ms-patientAdmin
     * @param token
     * @param patient
     * @return
     */
    ResponseEntity<Patient> createPatient(String token, Patient patient);

    /**
     *  Update patient to ms-patientAdmin
     * @param token
     * @param patient
     * @return
     */
    ResponseEntity<Patient> updatePatient(String token, Patient patient);

    /**
     *  Delete patient to ms-patientAdmin
     * @param token
     * @param id
     * @return
     */
    ResponseEntity<Void> deletePatient(String token, int id);

    /**
     * Search patient
     * @param token
     * @param search
     * @return
     */
    List<Patient> searchPatient(String token, String search);

}
