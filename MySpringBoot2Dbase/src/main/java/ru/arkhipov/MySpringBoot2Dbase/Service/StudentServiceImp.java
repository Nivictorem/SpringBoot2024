package ru.arkhipov.MySpringBoot2Dbase.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.arkhipov.MySpringBoot2Dbase.dao.StudentDAO;
import ru.arkhipov.MySpringBoot2Dbase.entity.Student;

import java.util.List;
@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDAO studentDAO;
    @Override
    @Transactional
    public List<Student> getAllStudents()
    {
        return studentDAO.getAllStudents();
    }
    @Override
    @Transactional
    public Student saveStudent(Student student)
    {
        return studentDAO.saveStudent(student);
    }
    @Override
    @Transactional
    public Student getStudent(int id)
    {
        return studentDAO.getStudent(id);
    }
    @Override
    @Transactional
    public void deleteStudent(int id)
    {
        studentDAO.deleteStudent(id);
    }
}
