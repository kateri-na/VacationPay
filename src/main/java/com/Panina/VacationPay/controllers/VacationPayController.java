package com.Panina.VacationPay.controllers;

import com.Panina.VacationPay.services.VacationPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@RequestMapping("/calculate")
@Controller
public class VacationPayController {
    @Autowired
    private VacationPayService service;

    @GetMapping
    public String calculation(@RequestParam(value = "yearAverageSalary", required = false) Double yearAverageSalary,
                              @RequestParam(value = "numberOfVacationDays", required = false) Integer numberOfVacationDays,
                              Model model){
        if (yearAverageSalary != null && numberOfVacationDays != null)
            model.addAttribute("vacationPay",
                    service.calculateVacationPay(yearAverageSalary, numberOfVacationDays));
        return "calculation";
    }
}
