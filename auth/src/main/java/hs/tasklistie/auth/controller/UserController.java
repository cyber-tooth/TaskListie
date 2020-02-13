package hs.tasklistie.auth.controller;

import hs.tasklistie.auth.dataTransferObject.LoginDto;
import hs.tasklistie.auth.dataTransferObject.SignupDto;
import hs.tasklistie.auth.service.UserService;
import hs.tasklistie.auth.web.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registrieren")
    public ModelAndView registrieren() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vt_register");
        return modelAndView;
    }
    @PostMapping("/registrieren")
    public ApiResponse signUp(@Valid SignupDto signupDto){ return userService.signUp(signupDto); }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vt_login");
        return modelAndView;
    }
    @PostMapping("/login")
    public ApiResponse login(@Valid LoginDto loginDto){
        return userService.login(loginDto);
    }

}
