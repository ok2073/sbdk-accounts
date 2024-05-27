package com.keelient.sbdkaccounts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountsController {

    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello world";
    }
}
