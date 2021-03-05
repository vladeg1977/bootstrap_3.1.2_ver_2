package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }



    @GetMapping
    public String adminPage(Model model) {
        List<User> list = userService.listUsers();
        model.addAttribute("users", list);
        model.addAttribute("user", new User());
        model.addAttribute("roles", userService.listRoles());
        return "admin";
    }


    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user,
                             @RequestParam("role_select") Long[] roleIds) {
        for (Long id : roleIds) {
            user.addRole(userService.getRoleById(id));
        }
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user,
                          @RequestParam("role_select") Long[] roleIds) {
        for (Long id : roleIds) {
            user.addRole(userService.getRoleById(id));
        }
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String delUser(@RequestParam("user_id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
