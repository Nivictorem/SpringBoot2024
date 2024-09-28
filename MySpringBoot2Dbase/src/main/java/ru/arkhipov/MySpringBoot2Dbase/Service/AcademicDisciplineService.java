package ru.arkhipov.MySpringBoot2Dbase.Service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.arkhipov.MySpringBoot2Dbase.entity.AcademicDiscipline;
import ru.arkhipov.MySpringBoot2Dbase.entity.Student;

import java.util.List;
@Service
public interface AcademicDisciplineService {

    List<AcademicDiscipline> getAllDisciplines();
    AcademicDiscipline saveDiscipline(AcademicDiscipline student);
    AcademicDiscipline getDiscipline(int id);
    void deleteDiscipline(int id);
}
