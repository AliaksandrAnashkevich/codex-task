package com.codex.controller;

import com.codex.entity.User;
import com.codex.service.impl.UserServiceImpl;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid User userForm,
                          BindingResult bindingResult,
                          Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!userForm.getPassword().equals(userForm.getPasswordConfirm())){
            model.addAttribute("messageError", "Password mismatch");
            return "registration";
        }

        if (!EmailValidator.getInstance().isValid(userForm.getEmail())){
            model.addAttribute("messageError", "Email field is empty");
            return "registration";
        }
        if (!userServiceImpl.saveUser(userForm)){
            model.addAttribute("messageError", "A user with the same name already exists");
            return "registration";
        }

        return "redirect:/";
    }
}
