package ru.arkhipov.MySecondTestAppSpingBoot.service;

import org.springframework.stereotype.Service;
import ru.arkhipov.MySecondTestAppSpingBoot.model.Positions;
@Service
public class AnnualBonusServiceImp implements AnnualBonusService{
    @Override
    public double calculate(Positions positions, double salary, double bonus,
                     int workDays, int year)
    {
        int DaysAtYear = 365;
        if(year%4 == 0) DaysAtYear = 366;
        return salary*bonus*DaysAtYear*positions.getPositionCoefficient()/workDays;
    }
}
