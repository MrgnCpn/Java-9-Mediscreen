package com.mediscreen.msmedicalrecord.interfaces;

import com.mediscreen.msmedicalrecord.models.MedicalRecord;

import java.util.List;

public interface MedicalRecordServiceInterface {

    /**
     * Get all patient medical records
     * @param id
     * @return
     */
    List<MedicalRecord> getPatientMedicalRecords(Integer id);

    /**
     * Update Medical Record
     * @param medicalRecord
     * @return
     */
    MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord);

    /**
     * Create Medical Record
     * @param medicalRecord
     * @return
     */
    MedicalRecord createMedicalRecord(MedicalRecord medicalRecord);
}
