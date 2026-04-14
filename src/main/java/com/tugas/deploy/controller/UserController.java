package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    // TEMPORARY STORAGE (tidak pakai database)
    private List<User> listMahasiswa = new ArrayList<>();

    //LOGIN
    @GetMapping("/")
    public String redirectLogin() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam String username,
                               @RequestParam String password) {

        // username = admin
        // password = bebas (misal nim)
        if (username.equals("admin")) {
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

    //HOME
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("listMahasiswa", listMahasiswa);
        return "home";
    }

    //FORM
    @GetMapping("/form")
    public String formPage() {
        return "form";
    }

    //SAVE DATA
    @PostMapping("/save")
    public String saveData(@RequestParam String nama,
                           @RequestParam String nim,
                           @RequestParam String jenisKelamin) {

        User user = new User(nama, nim, jenisKelamin);
        listMahasiswa.add(user);

        return "redirect:/home";
    }

    //LOGOUT
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}
