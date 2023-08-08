package jorge.mombach.school.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @GetMapping("/students")
    public String retrieveStudents(){
        return "All students here";
    }
}
