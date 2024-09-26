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
    // Уникальный идентификатор сообещния (неможет быть пустым)
    @NotBlank
    @Size(max = 32)
    private String uid;
    // Уникальный идентификатор операции (не может быть пустым)
    @NotBlank
    @Size(max = 32)
    private String operationUid;
    private Systems systemName; // Имя системы отправителя
    @NotBlank
    private String systemTime; // Время создания сообщения
    private String source; // Наименование ресурса
    private String position; // Должность отправителя

    private double bonus; // Коэффициент оклада
    private double salary; // Зарплата отправителя

    @Max(100000)
    @Min(1)
    private int communication; // Уникальный идентификатор коммуникации
    private int tamplateId; // Уникальный идентификатор шаблона
    private int productionCode; // Код продукта
    private int smsCode; // Смс код
    private int workDays; // Количество фактически отработанных дней в году

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
