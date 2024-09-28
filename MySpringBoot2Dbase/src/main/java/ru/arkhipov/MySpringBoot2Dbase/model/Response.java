package ru.arkhipov.MySpringBoot2Dbase.model;

import lombok.Builder;
import lombok.Data;
import ru.arkhipov.MySpringBoot2Dbase.entity.Student;

@Data
@Builder
public class Response {
    private Codes code; // Сообщение о выполнении операции (успешно|неуспешно)
    private String errorMessage; // Описание ошибки
    private Student student;
    @Override
    public String toString()
    {
        return "{" +
                ", code'" + code.toString() + '\'' +
                ", errorMessage'" + errorMessage + '\'' +
                ", errorMessage'" + student.toString() + '}';
    }
}
