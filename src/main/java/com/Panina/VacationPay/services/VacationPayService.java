package com.Panina.VacationPay.services;

import org.springframework.stereotype.Service;

@Service
public class VacationPayService {
    private static final double DAYS_IN_MONTH = 29.3;

    public double calculateVacationPay(double yearAverageSalary, int numberOfVacationDays){
        double dailyAverageSalary = yearAverageSalary / DAYS_IN_MONTH;
        return Math.round(dailyAverageSalary * numberOfVacationDays);
    }
}
