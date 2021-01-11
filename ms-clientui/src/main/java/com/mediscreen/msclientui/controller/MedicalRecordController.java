package com.mediscreen.msclientui.controller;

import com.mediscreen.msclientui.interfaces.MedicalRecordServiceInterface;
import com.mediscreen.msclientui.interfaces.SecurityServiceInterface;
import com.mediscreen.msclientui.model.MedicalRecord;
import com.mediscreen.msclientui.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class MedicalRecordController {
    @Autowired
    private ControllerUtils controllerUtils;

    @Autowired
    private SecurityServiceInterface securityService;

    @Autowired
    private MedicalRecordServiceInterface medicalRecordService;

    @PostMapping("/medical-record/create/{id}")
    public ModelAndView createMedicalRecord(HttpSession session, @PathVariable(value="id") Integer id, @ModelAttribute MedicalRecord medicalRecord){
        try {
            medicalRecord.setPatientId(id);
            MedicalRecord newMedicalRecord = medicalRecordService.createMedicalRecord(session, medicalRecord);
            return controllerUtils.doRedirect("/patient/" + id);
        } catch (RuntimeException e){
            return controllerUtils.doRedirect("/patient/create?error=" + e);
        }
    }
}
