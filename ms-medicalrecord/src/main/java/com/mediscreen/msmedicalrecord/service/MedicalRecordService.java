package com.mediscreen.msmedicalrecord.service;

import com.mediscreen.msmedicalrecord.exception.NotFoundException;
import com.mediscreen.msmedicalrecord.interfaces.MedicalRecordDaoInterface;
import com.mediscreen.msmedicalrecord.interfaces.MedicalRecordServiceInterface;
import com.mediscreen.msmedicalrecord.model.MedicalRecord;
import com.mediscreen.msmedicalrecord.proxy.MSZuulProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

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
     * ems-zuul proxy
     */
    @Autowired
    private MSZuulProxy msZuulProxy;

    /**
     * Constructor
     * @param medicalRecordDao
     */
    public MedicalRecordService(MedicalRecordDaoInterface medicalRecordDao) {
        this.medicalRecordDao = medicalRecordDao;
    }

    /**
     * @see MedicalRecordServiceInterface {@link #getPatientMedicalRecords(String, Integer)}
     */
    @Override
    public List<MedicalRecord> getPatientMedicalRecords(String token, Integer id) {
        if (id != null && id > 0) {
            if (msZuulProxy.msPatientAdmin_getPatient(token, id) == null) throw new NotFoundException("Unknown patient with id : " + id);
            return medicalRecordDao.getAllPatientMedicalRecords(id);
        }
        return null;
    }

    /**
     * @see MedicalRecordServiceInterface {@link #createMedicalRecord(String, MedicalRecord)}
     */
    @Override
    public MedicalRecord createMedicalRecord(String token, MedicalRecord medicalRecord){
        if (
            medicalRecord.getId() != null &&
            medicalRecord.getId() > 0 &&
            medicalRecord.getPatientId() != null &&
            medicalRecord.getPatientId() > 0
        ) {
            if (msZuulProxy.msPatientAdmin_getPatient(token, medicalRecord.getId()) == null) throw new NotFoundException("Unknown patient with id : " + medicalRecord.getId());
            return medicalRecordDao.createMedicalRecord(medicalRecord);
        }
        return null;
    }

    /**
     * @see MedicalRecordServiceInterface {@link #updateMedicalRecord(String, MedicalRecord)}
     */
    @Override
    public MedicalRecord updateMedicalRecord(String token, MedicalRecord medicalRecord) {
        if (
            medicalRecord.getId() != null &&
            medicalRecord.getId() > 0 &&
            medicalRecord.getPatientId() != null &&
            medicalRecord.getPatientId() > 0
        ) {
            if (msZuulProxy.msPatientAdmin_getPatient(token, medicalRecord.getId()) == null) throw new NotFoundException("Unknown patient with id : " + medicalRecord.getId());
            return medicalRecordDao.updateMedicalRecord(medicalRecord);
        }
        return null;
    }
}
