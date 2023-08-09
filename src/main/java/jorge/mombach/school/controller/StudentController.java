package jorge.mombach.school.controller;

import jakarta.validation.Valid;
import jorge.mombach.school.dto.StudentDtoRequest;
import jorge.mombach.school.dto.StudentDtoResponse;
import jorge.mombach.school.service.ClassroomService;
import jorge.mombach.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    ClassroomService classroomService;

    @PostMapping("/classroom/{id}/students")
    public ResponseEntity<Object> createStudentInClassroom(
            @PathVariable Long id,
            @Valid @RequestBody StudentDtoRequest studentDtoRequest) {

        StudentDtoResponse savedStudent = studentService.createStudentInClassroom(id, studentDtoRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedStudent.getStudent_id())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/classroom/{id}/students")
    public List<StudentDtoResponse> getStudentsByClassroom(@PathVariable Long id) {
        return studentService.getStudentsByClassroom(id);
    }
}
