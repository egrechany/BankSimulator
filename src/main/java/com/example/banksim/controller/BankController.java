package com.example.banksim.controller;

import com.example.banksim.repository.User;
import com.example.banksim.service.AuditService;
import com.example.banksim.service.IAuditService;
import com.example.banksim.service.ILoggingService;
import com.example.banksim.service.LoggingServiceAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api")
public class BankController {

    @Autowired
    AuditService audit;


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
        return false;
    }
}
