package ru.arkhipov.MySpringBoot2Dbase.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.arkhipov.MySpringBoot2Dbase.dao.AcademicDiscipline_DAO;
import ru.arkhipov.MySpringBoot2Dbase.dao.StudentDAO;
import ru.arkhipov.MySpringBoot2Dbase.entity.AcademicDiscipline;
import ru.arkhipov.MySpringBoot2Dbase.entity.Student;

import java.util.List;
@Service
public class AcademicDisciplineServiceImp implements AcademicDisciplineService {
    @Autowired
    private AcademicDiscipline_DAO academicDisciplineDao;
    @Override
    @Transactional
    public List<AcademicDiscipline> getAllDisciplines()
    {
        return academicDisciplineDao.getAllDisciplines();
    }
    @Override
    @Transactional
    public AcademicDiscipline saveDiscipline(AcademicDiscipline academicDiscipline)
    {
        return academicDisciplineDao.saveDiscipline(academicDiscipline);
    }
    @Override
    @Transactional
    public AcademicDiscipline getDiscipline(int id)
    {
        return academicDisciplineDao.getDiscipline(id);
    }
    @Override
    @Transactional
    public void deleteDiscipline(int id)
    {
        academicDisciplineDao.deleteDiscipline(id);
    }
}
