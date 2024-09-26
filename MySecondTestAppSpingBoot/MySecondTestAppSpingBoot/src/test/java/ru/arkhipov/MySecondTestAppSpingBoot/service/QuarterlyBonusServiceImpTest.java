package ru.arkhipov.MySecondTestAppSpingBoot.service;

import org.junit.jupiter.api.Test;
import ru.arkhipov.MySecondTestAppSpingBoot.model.Positions;

import static org.junit.jupiter.api.Assertions.*;

class QuarterlyBonusServiceImpTest {

    @Test
    void calculate() {
        Positions positions = Positions.HR;
        double bonus = 2;
        int workDays = 243;
        double salary = 100000;
        double result = new QuarterlyBonusServiceImp().calculate(
                positions, salary, bonus, workDays, 2023
        );
        double expected = 0;
        assertEquals(expected, result);

        positions = Positions.SUPM;
        expected = 438196.72131147540;
        result = new QuarterlyBonusServiceImp().calculate(
                positions, salary, bonus, workDays, 2024
        );
        assertEquals(expected, result);
    }
}