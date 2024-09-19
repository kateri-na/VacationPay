package com.Panina.VacationPay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/calculate")
@Controller
public class VacationPayController {
    @GetMapping
    public String calculation(){
        return "calculation";
    }
}
