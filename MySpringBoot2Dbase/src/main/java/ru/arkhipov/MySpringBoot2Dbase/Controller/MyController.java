package ru.arkhipov.MySpringBoot2Dbase.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.arkhipov.MySpringBoot2Dbase.Service.StudentService;
import ru.arkhipov.MySpringBoot2Dbase.entity.Student;
import ru.arkhipov.MySpringBoot2Dbase.model.Codes;
import ru.arkhipov.MySpringBoot2Dbase.model.Response;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public List<Student> allStudent()
    {
        List<Student> studentList = studentService.getAllStudents();
        return studentList;
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Response> getStudent(@PathVariable("id") int id)
    {
        Response response = Response.builder().build();
        response.setCode(Codes.SUCCES);
        try
        {
            response.setStudent(studentService.getStudent(id));
            if (response.getStudent() == null)
            {
                response.setCode(Codes.FAILED);
                response.setErrorMessage("Такого студента нет");
            }
        } catch (Exception e)
        {
            response.setCode(Codes.FAILED);
            response.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/students")
    public ResponseEntity<Response> saveStudent(@RequestBody Student student)
    {
        Response response = Response.builder().build();
        response.setCode(Codes.SUCCES);
        try
        {
            response.setStudent(studentService.saveStudent(student));
        } catch (Exception e)
        {
            response.setCode(Codes.FAILED);
            response.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping("/students")
    public ResponseEntity<Response> updateStudent(@RequestBody Student student)
    {
        Response response = Response.builder().build();
        response.setCode(Codes.SUCCES);
        try
        {
            response.setStudent(studentService.saveStudent(student));
        } catch (Exception e)
        {
            response.setCode(Codes.FAILED);
            response.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<Response> deleteStudent(@PathVariable("id") int id)
    {
        Response response = Response.builder().build();
        response.setCode(Codes.SUCCES);
        try
        {
            Student student = studentService.getStudent(id);
            if (student == null)
            {
                response.setCode(Codes.FAILED);
                response.setErrorMessage("Такого студента нет");
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            studentService.deleteStudent(id);
        } catch (Exception e)
        {
            response.setCode(Codes.FAILED);
            response.setErrorMessage(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
