package com.shubhranshi.todo.controller;

import com.shubhranshi.todo.dao.UserDao;
import com.shubhranshi.todo.model.RegisterDto;
import com.shubhranshi.todo.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/register")
    public String register(Model model){
        RegisterDto registerDto= new RegisterDto();
        model.addAttribute(registerDto);
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @Valid @ModelAttribute RegisterDto registerDto, BindingResult result) {

        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
            result.addError(new FieldError("registerDto", "confirmPassword", "password and confirm password do not match"));
        }

        User user = userDao.findByUsername(registerDto.getUsername());
        if(user!=null){
            result.addError(new FieldError("registerDto", "username", "username not available"));
        }

        if (result.hasErrors()) {
            return "register";
        }

        try{
            var bCryptEncoder= new BCryptPasswordEncoder();

            User newUser= new User();
            newUser.setUsername(registerDto.getUsername());
            newUser.setEmail(registerDto.getEmail());
            newUser.setPassword(bCryptEncoder.encode(registerDto.getPassword()));
            userDao.save(newUser);
            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success", true);

        } catch (Exception ex){
            result.addError(new FieldError("registerDto","username",ex.getMessage()));
        }

        return "register";

    }
}
