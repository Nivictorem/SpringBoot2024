package ru.arkhipov.MySecondTestAppSpingBoot.model;

import lombok.Getter;

@Getter
public enum Positions {
    Dev(2.2, false),
    HR(1.2, false),
    TL(2.6, false),
    PM(2.5, true),
    SUPP(1.5, false),
    SUPM(1.1, true);
    private final double positionCoefficient;
    private final boolean isManager;
    Positions(double positionCoefficient, boolean isManager)
    {
        this.positionCoefficient = positionCoefficient;
        this.isManager = isManager;
    }
}
