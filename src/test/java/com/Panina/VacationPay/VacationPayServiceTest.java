package com.Panina.VacationPay;

import com.Panina.VacationPay.services.VacationPayService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VacationPayServiceTest {
    @Autowired
    VacationPayService service;

    @Test
    void calculationVacationPay(){
        assertEquals(95563.0, service.calculateVacationPay(100000.0,28));
    }

    @Test
    void calculationVacationPayWithDates(){
        assertEquals(0.0, service.calculateVacationPay(100000.0, 8,
                LocalDate.parse("2025-01-01"), LocalDate.parse("2025-01-08")));
    }
}
