package ru.arkhipov.MySecondTestAppSpingBoot.service;

import org.junit.jupiter.api.Test;
import ru.arkhipov.MySecondTestAppSpingBoot.model.Positions;

import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class AnnualBonusServiceImpTest {

    @Test
    void calculate() {
        Positions positions = Positions.HR;
        double bonus = 2;
        int workDays = 243;
        double salary = 100000;
        double result = new AnnualBonusServiceImp().calculate(
                positions, salary, bonus, workDays, 2023
        );
        double expected = 360493.8271604938;
        assertEquals(expected, result);

        expected = 361481.48148148146;
        result = new AnnualBonusServiceImp().calculate(
                positions, salary, bonus, workDays, 2023
        );
        assertEquals(expected, result);
    }
}