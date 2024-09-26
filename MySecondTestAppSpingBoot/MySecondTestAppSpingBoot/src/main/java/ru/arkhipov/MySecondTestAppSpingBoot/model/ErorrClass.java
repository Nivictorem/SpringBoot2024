package ru.arkhipov.MySecondTestAppSpingBoot.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErorrClass {
    public ErrorCodes errorCodes;
    public ErrorMessages errorMessages;
    public Codes codes;
}
