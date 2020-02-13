package hs.tasklistie.auth.controller;

import hs.tasklistie.auth.dataTransferObject.LoginDto;
import hs.tasklistie.auth.dataTransferObject.SignupDto;
import hs.tasklistie.auth.service.UserService;
import hs.tasklistie.auth.web.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public SignupDto signupDto() {
        return new SignupDto();
    }

    @GetMapping("/registrieren")
    public String signUpForm(Model model) {
        return "/vt_register";
    }

    @PostMapping("/registrieren")
    public ApiResponse signUp(@ModelAttribute("user") @Valid @RequestBody SignupDto signupDto){ return userService.signUp(signupDto); }

    @PostMapping("/login")
    public ApiResponse login(@Valid @RequestBody LoginDto loginDto){
        return userService.login(loginDto);
    }

//    @GetMapping("user")
//    public ApiResponse getUser()

}
