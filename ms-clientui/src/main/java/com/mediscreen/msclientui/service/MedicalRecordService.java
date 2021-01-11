package com.mediscreen.msclientui.service;

import com.mediscreen.msclientui.interfaces.MedicalRecordServiceInterface;
import com.mediscreen.msclientui.interfaces.SecurityServiceInterface;
import com.mediscreen.msclientui.model.MedicalRecord;
import com.mediscreen.msclientui.proxy.MSZuulProxy;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MedicalRecordService implements MedicalRecordServiceInterface {
    /**
     * Zuul proxy
     */
    @Autowired
    private MSZuulProxy msZuulProxy;

    /**
     * Security service
     */
    @Autowired
    private SecurityServiceInterface securityService;

    /**
     * @see MedicalRecordServiceInterface {@link #getAllPatientMedicalRecords(HttpSession, int)}
     */
    @Override
    public List<MedicalRecord> getAllPatientMedicalRecords(HttpSession session, int patientId) {
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        medicalRecordList.add(new MedicalRecord("_id", 1, "FREEMAN Claude", LocalDateTime.now(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan venenatis metus, hendrerit vehicula dui condimentum ut. Proin ut varius mauris, eu tempor sem. Maecenas risus felis, posuere non elit malesuada, cursus mattis lacus.", true));
        medicalRecordList.add(new MedicalRecord("_id", 1, "MITCHELL Renee", LocalDateTime.now(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan venenatis metus, hendrerit vehicula dui condimentum ut. Proin ut varius mauris, eu tempor sem. Maecenas risus felis, posuere non elit malesuada, cursus mattis lacus.", true));
        medicalRecordList.add(new MedicalRecord("_id", 1, "MITCHELL Renee", LocalDateTime.now(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan venenatis metus, hendrerit vehicula dui condimentum ut. Proin ut varius mauris, eu tempor sem. Maecenas risus felis, posuere non elit malesuada, cursus mattis lacus.", false));
        medicalRecordList.add(new MedicalRecord("_id", 1, "HORTON Georgia", LocalDateTime.now(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan venenatis metus, hendrerit vehicula dui condimentum ut. Proin ut varius mauris, eu tempor sem. Maecenas risus felis, posuere non elit malesuada, cursus mattis lacus.", true));
        return medicalRecordList;
    }

    /**
     * @see MedicalRecordServiceInterface {@link #createMedicalRecord(HttpSession, MedicalRecord)}
     */
    @Override
    public MedicalRecord createMedicalRecord(HttpSession session, MedicalRecord medicalRecord) {
        return new MedicalRecord("_id", 1, "FREEMAN Claude", LocalDateTime.now(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan venenatis metus, hendrerit vehicula dui condimentum ut. Proin ut varius mauris, eu tempor sem. Maecenas risus felis, posuere non elit malesuada, cursus mattis lacus.", true);
    }

    /**
     * @see MedicalRecordServiceInterface {@link #updateMedicalRecord(HttpSession, MedicalRecord)}
     */
    @Override
    public MedicalRecord updateMedicalRecord(HttpSession session, MedicalRecord medicalRecord) {
        return new MedicalRecord("_id", 1, "FREEMAN Claude", LocalDateTime.now(), "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed accumsan venenatis metus, hendrerit vehicula dui condimentum ut. Proin ut varius mauris, eu tempor sem. Maecenas risus felis, posuere non elit malesuada, cursus mattis lacus.", true);
    }
}
