package ru.arkhipov.MySecondTestAppSpingBoot.service;

import org.springframework.stereotype.Service;
import ru.arkhipov.MySecondTestAppSpingBoot.model.Positions;
@Service
public class QuarterlyBonusServiceImp implements QuarterlyBonusService{
    @Override
    public double calculate(Positions positions, double salary, double bonus,
                     int workDays, int year)
    {
        if(!positions.isManager()) return 0;
        int DaysAtYear = 365;
        if(year%4 == 0) DaysAtYear = 366;
        return salary*bonus*3*positions.getPositionCoefficient()*workDays/DaysAtYear;
    }
}
