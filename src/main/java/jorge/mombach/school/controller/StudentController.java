package jorge.mombach.school.controller;

import jorge.mombach.school.dto.StudentDtoRequest;
import jorge.mombach.school.dto.StudentDtoResponse;
import jorge.mombach.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("student")
    public StudentDtoRequest post(@RequestBody StudentDtoRequest studentDtoRequest){
        return studentService.save(studentDtoRequest);
    }

    @GetMapping("/student")
    public List<StudentDtoResponse> retrieveAllStudents(){
        return studentService.findAll();
    }
}
