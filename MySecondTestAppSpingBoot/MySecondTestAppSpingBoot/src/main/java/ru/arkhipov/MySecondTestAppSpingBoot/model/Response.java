package ru.arkhipov.MySecondTestAppSpingBoot.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private String uid; // Уникальный идентификатор сообщения
    private String operationUid; // Уникальный идентификатор операции
    private String systemTime; // Время создания сообщения
    private Codes code; // Сообщение о выполнении операции (успешно|неуспешно)
    private Double annualBonus;// Размер годового бонуса
    private ErrorCodes errorCode; // Код ошибки
    private ErrorMessages errorMessage; // Описание ошибки
    @Override
    public String toString()
    {
        return "{" +
                "uid'" + uid + '\'' +
                ", operationUid'" + operationUid + '\'' +
                ", systemTime'" + systemTime + '\'' +
                ", annualBonus'" + annualBonus + '\'' +
                ", code'" + code.toString() + '\'' +
                ", errorCode'" + errorCode + '\'' +
                ", errorMessage'" + errorMessage + "}";
    }
}
