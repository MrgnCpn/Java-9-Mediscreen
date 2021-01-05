package com.mediscreen.msclientui.controller;

import com.mediscreen.msclientui.exception.NotAllowedException;
import com.mediscreen.msclientui.exception.NotFoundException;
import com.mediscreen.msclientui.interfaces.PatientServiceInterface;
import com.mediscreen.msclientui.interfaces.SecurityServiceInterface;
import com.mediscreen.msclientui.models.Patient;
import com.mediscreen.msclientui.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PatientController {

    @Autowired
    private ControllerUtils controllerUtils;

    @Autowired
    private SecurityServiceInterface securityService;

    @Autowired
    private PatientServiceInterface patientService;

    @GetMapping("/search")
    public ModelAndView getSearch(HttpSession session){
        if (!securityService.isLog(session)) return controllerUtils.rootRedirect();

        Map<String, Object> model = new HashMap<>();
        model.put("page", "search");
        model.put("patients", patientService.getAllPatients((String) session.getAttribute("token")));
        model.put("isLogin", true);

        return new ModelAndView("template.html" , model);
    }

    @GetMapping("/patient/search")
    public List<Patient> searchPatient(HttpSession session, @RequestParam(required = true) String search) {
        return patientService.searchPatient((String) session.getAttribute("token"), search);
    }

    @GetMapping("/patient")
    public ModelAndView getPatient(HttpSession session){
        if (!securityService.isLog(session)) return controllerUtils.rootRedirect();
        else return controllerUtils.doRedirect("/search");
    }

    @GetMapping("/patient/{id}")
    public ModelAndView getPatientSection(HttpSession session, @PathVariable(value="id") Integer id){
        if (!securityService.isLog(session)) return controllerUtils.rootRedirect();

        Map<String, Object> model = new HashMap<>();
        model.put("page", "patient-sheet");
        model.put("patient", patientService.getPatient((String) session.getAttribute("token"), id));
        model.put("isLogin", true);

        return new ModelAndView("template.html" , model);
    }

    @PostMapping("/patient/{id}/create")
    public ModelAndView createPatient(HttpSession session, @PathVariable(value="id") Integer id, @RequestParam Patient patient){
        if(!securityService.isLog(session)) throw new NotAllowedException("Permission denied");
        if(patientService.getPatient((String) session.getAttribute("token"), id) == null) throw new NotFoundException("Patient id unknown");
        patient.setId(id);
        patientService.createPatient((String) session.getAttribute("token"), patient);
        return controllerUtils.doRedirect("/patient/" + String.valueOf(id));
    }

    @PostMapping("/patient/{id}/update")
    public ModelAndView updatePatient(HttpSession session, @PathVariable(value="id") Integer id, @RequestParam Patient patient){
        if(!securityService.isLog(session)) throw new NotAllowedException("Permission denied");
        if(patientService.getPatient((String) session.getAttribute("token"), id) == null) throw new NotFoundException("Patient id unknown");
        patient.setId(id);
        patientService.updatePatient((String) session.getAttribute("token"), patient);
        return controllerUtils.doRedirect("/patient/" + String.valueOf(id));
    }

    @GetMapping("/patient/{id}/delete")
    public ModelAndView deletePatient(HttpSession session, @PathVariable(value="id") Integer id){
        if(!securityService.isLog(session)) throw new NotAllowedException("Permission denied");
        if(patientService.getPatient((String) session.getAttribute("token"), id) == null) throw new NotFoundException("Patient id unknown");
        patientService.deletePatient((String) session.getAttribute("token"), id);
        return controllerUtils.doRedirect("/search");
    }
}