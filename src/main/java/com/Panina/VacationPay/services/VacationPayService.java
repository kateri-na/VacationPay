package com.Panina.VacationPay.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Service
public class VacationPayService {
    private static final double DAYS_IN_MONTH = 29.3;

    public double calculateVacationPay(double yearAverageSalary, int numberOfVacationDays){
        double dailyAverageSalary = yearAverageSalary / DAYS_IN_MONTH;
        return Math.round(dailyAverageSalary * numberOfVacationDays);
    }
    public double calculateVacationPay(double yearAverageSalary, int numberOfVacationDays,
                                       LocalDate startOfVacation, LocalDate endOfVacation){
        int year = endOfVacation.getYear();
        Set<LocalDate> holidays = createHolidays(year);
        for(LocalDate holiday:holidays){
            if(holiday.isEqual(startOfVacation) || holiday.isEqual(endOfVacation))
                --numberOfVacationDays;
            else if (holiday.isAfter(startOfVacation) && holiday.isBefore(endOfVacation)) {
                --numberOfVacationDays;

            }
        }
        return calculateVacationPay(yearAverageSalary, numberOfVacationDays);
    }

    private Set<LocalDate> createHolidays(int year){
        Set<LocalDate> holidays = new HashSet<LocalDate>();
        holidays.add(LocalDate.parse(year + "-01-01"));
        holidays.add(LocalDate.parse(year + "-01-02"));
        holidays.add(LocalDate.parse(year + "-01-03"));
        holidays.add(LocalDate.parse(year + "-01-04"));
        holidays.add(LocalDate.parse(year + "-01-05"));
        holidays.add(LocalDate.parse(year + "-01-06"));
        holidays.add(LocalDate.parse(year + "-01-07"));
        holidays.add(LocalDate.parse(year + "-01-08"));
        holidays.add(LocalDate.parse(year + "-02-23"));
        holidays.add(LocalDate.parse(year + "-03-08"));
        holidays.add(LocalDate.parse(year + "-05-01"));
        holidays.add(LocalDate.parse(year + "-05-09"));
        holidays.add(LocalDate.parse(year + "-06-12"));
        holidays.add(LocalDate.parse(year + "-11-14"));
        return holidays;
    }
}
