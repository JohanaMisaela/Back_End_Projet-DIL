package com.gondor.chic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @GetMapping("/")
    public String home() {
        return "Backend Gondor Chic is running!";
    }
}
