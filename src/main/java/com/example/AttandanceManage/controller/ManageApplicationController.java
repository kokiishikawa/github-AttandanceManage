package com.example.AttandanceManage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManageApplicationController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/login")
    public String logout() {
        return "login";
    }
    @RequestMapping("user_add")
    public String user_add() {
        return "user_add";
    }
}
