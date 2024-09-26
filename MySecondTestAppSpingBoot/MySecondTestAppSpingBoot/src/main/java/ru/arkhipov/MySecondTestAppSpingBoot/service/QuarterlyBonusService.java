package ru.arkhipov.MySecondTestAppSpingBoot.service;

import org.springframework.stereotype.Service;
import ru.arkhipov.MySecondTestAppSpingBoot.model.Positions;
@Service
public interface QuarterlyBonusService {
    double calculate(Positions positions, double salary, double bonus,
                     int workDays, int year);
}
