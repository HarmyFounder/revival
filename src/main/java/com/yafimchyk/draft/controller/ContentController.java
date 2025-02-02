package com.yafimchyk.draft.controller;

import com.yafimchyk.draft.entity.MyUser;
import com.yafimchyk.draft.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class ContentController {

    
    @GetMapping("/login")
    public String login(){
        return "loginYo";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signupYo";
    }

    @GetMapping("/home")
    public String home(){
        return "index";
    }




}
