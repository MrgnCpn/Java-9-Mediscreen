package com.mediscreen.msmedicalrecord.dao;

import com.mediscreen.msmedicalrecord.interfaces.DatabaseConfigurationInterface;
import com.mediscreen.msmedicalrecord.interfaces.MedicalRecordDaoInterface;
import com.mediscreen.msmedicalrecord.models.MedicalRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordDao implements MedicalRecordDaoInterface {
    /**
     * Logger log4j2
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Database configuration
     */
    private DatabaseConfigurationInterface databaseConfiguration;

    /**
     * Constructor
     * @param databaseConfiguration
     */
    public MedicalRecordDao(DatabaseConfigurationInterface databaseConfiguration) {
        this.databaseConfiguration = databaseConfiguration;
    }

    /**
     * @see MedicalRecordDaoInterface {@link #getAllPatientMedicalRecords(Integer)}
     */
    @Override
    public List<MedicalRecord> getAllPatientMedicalRecords(Integer patientId){
        List<MedicalRecord> result = new ArrayList<>();
        result.add(new MedicalRecord(1, patientId, "Dr. Doc", LocalDate.now(), "content", true));
        result.add(new MedicalRecord(2, patientId, "Dr. Doc", LocalDate.now(), "content", false));
        result.add(new MedicalRecord(3, patientId, "Dr. Doc", LocalDate.now(), "content", true));
        result.add(new MedicalRecord(4, patientId, "Dr. Doc", LocalDate.now(), "content", true));
        result.add(new MedicalRecord(5, patientId, "Dr. Doc", LocalDate.now(), "content", false));
        result.add(new MedicalRecord(6, patientId, "Dr. Doc", LocalDate.now(), "content", true));

        return result;
    }

    /**
     * @see MedicalRecordDaoInterface {@link #createMedicalRecord(MedicalRecord)}
     */
    @Override
    public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord){
        return medicalRecord;
    }

    /**
     * @see MedicalRecordDaoInterface {@link #updateMedicalRecord(MedicalRecord)}
     */
    @Override
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord){
        return medicalRecord;
    }
}
