package com.mediscreen.msclientui.controller;

import com.mediscreen.msclientui.interfaces.SecurityServiceInterface;
import com.mediscreen.msclientui.models.Login;
import com.mediscreen.msclientui.utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthenticateController {

    @Autowired
    private ControllerUtils controllerUtils;

    @Autowired
    private SecurityServiceInterface securityService;

    @GetMapping("/login")
    public ModelAndView getLogin(HttpSession session){
        if (securityService.isLog(session)) return controllerUtils.rootRedirect();

        Map<String, Object> model = new HashMap<>();
        model.put("page", "login");
        model.put("isLogin", true);

        return new ModelAndView("template.html" , model);
    }

    @PostMapping("/login")
    public ModelAndView postLogin(HttpSession session, @RequestParam Login login){
        Map<String, String> userLogin = securityService.logUser(login);
        if (userLogin != null) userLogin.forEach((k, v) -> session.setAttribute(k, v));

        return controllerUtils.rootRedirect();
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session){
        session.invalidate();
        return controllerUtils.rootRedirect();
    }
}
