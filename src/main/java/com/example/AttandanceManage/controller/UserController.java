package com.example.AttandanceManage.controller;

import com.example.AttandanceManage.model.User;
import com.example.AttandanceManage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
    private JdbcTemplate jdbcTemplate;


    @GetMapping("/users_list")
    public String index(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users_list";
    }

//    @GetMapping("/user_add")
//    public String add(Model model) {
//        return "user_add";
//    }
//    @PostMapping("/user_edit")
//    public String edit(@ModelAttribute User user) {
//        userRepository.insert(user);
//        return "redirect:user";
//    }
}