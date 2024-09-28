package ru.arkhipov.MySpringBoot2Dbase.dao;

import org.springframework.stereotype.Repository;
import ru.arkhipov.MySpringBoot2Dbase.entity.AcademicDiscipline;
import ru.arkhipov.MySpringBoot2Dbase.entity.Student;

import java.util.List;
@Repository
public interface AcademicDiscipline_DAO {
    List<AcademicDiscipline> getAllDisciplines();
    AcademicDiscipline saveDiscipline(AcademicDiscipline discipline);
    AcademicDiscipline getDiscipline(int id);
    void deleteDiscipline(int id);
}
