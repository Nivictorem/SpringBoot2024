package ru.arkhipov.MySecondTestAppSpingBoot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    /**
     * Уникальный идентификатор сообещния (неможет быть пустым)
     */
    @NotBlank
    @Size(max = 32)
    private String uid;
    /**
     * Уникальный идентификатор операции (не может быть пустым)
     */
    @NotBlank
    @Size(max = 32)
    private String operationUid;
    /**
     * Имя системы отправителя
     */
    private Systems systemName;
    /**
     *  Время создания сообщения
     */
    @NotBlank
    private String systemTime;
    /**
     * Наименование ресурса
     */
    private String source;
    /**
     * Должность отправителя
     */
    private String position;
    /**
     * Коэффициент оклада
     */
    private double bonus;
    /**
     * Зарплата отправителя
     */
    private double salary;
    /**
     * Уникальный идентификатор коммуникации
     */
    @Max(100000)
    @Min(1)
    private int communication;
    /**
     * Уникальный идентификатор шаблона
     */
    private int tamplateId;
    /**
     * Код продукта
     */
    private int productionCode;
    /**
     * Смс код
     */
    private int smsCode;
    /**
     * Количество фактически отработанных дней в году
     */
    private int workDays;

    @Override
    public String toString()
    {
        return "{" +
                "uid'" + uid + '\'' +
                ", operationUid'" + operationUid + '\'' +
                ", systemName''" + systemName + '\'' +
                ", systemTime'" + systemTime + '\'' +
                ", source'" + source + '\'' +
                ", communication'" + communication + '\'' +
                ", tamplateId'" + tamplateId + '\'' +
                ", productionCode'" + productionCode + '\'' +
                ", smsCode'" + smsCode + '\'' + "}";
    }
}
