package com.reward.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerLogin {




    @GetMapping("/login")
    public String home(){
        return "welcome";
    }

    @GetMapping("/")
    public String index(@AuthenticationPrincipal UserDetails userDetails, Authentication authentication){
        if (authentication!= null ){
            return "index";
        }

        else
            return "redirect:/login";

    }

}
