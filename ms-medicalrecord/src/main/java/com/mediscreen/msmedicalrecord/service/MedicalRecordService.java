package com.mediscreen.msmedicalrecord.service;

import com.mediscreen.msmedicalrecord.interfaces.MedicalRecordDaoInterface;
import com.mediscreen.msmedicalrecord.interfaces.MedicalRecordServiceInterface;
import com.mediscreen.msmedicalrecord.models.MedicalRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class MedicalRecordService implements MedicalRecordServiceInterface {
    /**
     * Logger log4j2
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * MedicalRecordDao
     */
    private MedicalRecordDaoInterface medicalRecordDao;

    /**
     * Constructor
     * @param medicalRecordDao
     */
    public MedicalRecordService(MedicalRecordDaoInterface medicalRecordDao) {
        this.medicalRecordDao = medicalRecordDao;
    }

    /**
     * @see MedicalRecordServiceInterface {@link #getPatientMedicalRecords(Integer)}
     */
    @Override
    public List<MedicalRecord> getPatientMedicalRecords(Integer id) {
        List<MedicalRecord> medicalRecordList = null;
        if (id != null && id > 0) {
            medicalRecordList = medicalRecordDao.getAllPatientMedicalRecords(id);
        }
        return medicalRecordList;
    }

    /**
     * @see MedicalRecordServiceInterface {@link #createMedicalRecord(MedicalRecord)}
     */
    @Override
    public MedicalRecord createMedicalRecord(MedicalRecord medicalRecord){
        if (
            medicalRecord.getId() != null &&
            medicalRecord.getId() > 0 &&
            medicalRecord.getPatientId() != null &&
            medicalRecord.getPatientId() > 0
        ) {
            return medicalRecordDao.createMedicalRecord(medicalRecord);
        }
        return null;
    }

    /**
     * @see MedicalRecordServiceInterface {@link #updateMedicalRecord(MedicalRecord)}
     */
    @Override
    public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
        if (
            medicalRecord.getId() != null &&
            medicalRecord.getId() > 0 &&
            medicalRecord.getPatientId() != null &&
            medicalRecord.getPatientId() > 0
        ) {
            return medicalRecordDao.updateMedicalRecord(medicalRecord);
        }
        return null;
    }
}
