package jorge.mombach.school.controller;

import jorge.mombach.school.dto.StudentDtoRequest;
import jorge.mombach.school.dto.StudentDtoResponse;
import jorge.mombach.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public StudentDtoRequest saveStudent(@RequestBody StudentDtoRequest studentDtoRequest){
        return studentService.save(studentDtoRequest);
    }

    @GetMapping("/student")
    public List<StudentDtoResponse> retrieveAllStudents(){
        return studentService.findAll();
    }

    @PutMapping("/student/{student_id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long student_id, @RequestBody StudentDtoRequest studentDtoRequest){
        String result = studentService.updateStudent(student_id, studentDtoRequest);

        if(result.equals("Student updated successfully.")){
            return ResponseEntity.ok(result);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/student/{student_id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long student_id) {
        studentService.deleteStudent(student_id);
        return ResponseEntity.ok().build();
    }
}
