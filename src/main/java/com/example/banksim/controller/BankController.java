package com.example.banksim.controller;

import com.example.banksim.repository.User;
import com.example.banksim.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api")
public class BankController {

    @Autowired
    AuditService audit;

    @Autowired
    RegistrationService registrationService;


    @GetMapping("/public/Info")
    public String returnInfo(){

        return "Hello";
    }

    @GetMapping("/admin/Info")
    public String returnAdminInfo(){
        return "HelloAdmin";
    }

    @PostMapping("/admin/registerUser")
    public Boolean createUser(@RequestBody User user){
        return registrationService.registerUser(user);
    }

    @PostMapping("/admin/deleteUser")
    public Boolean deleteUser(@RequestBody User user){
        return true;
    }
}
