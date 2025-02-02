package com.yafimchyk.draft.controller;

import com.yafimchyk.draft.entity.MyUser;
import com.yafimchyk.draft.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/signup")
    public String addUser(MyUser user, Model model){
        MyUser userFromDb = myUserRepository.findByUsername(user.getUsername());

        if(userFromDb != null){

            model.addAttribute("message","user exists!");
            return "signupYo";
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        myUserRepository.save(user);

        return "redirect:/login";
    }



}
