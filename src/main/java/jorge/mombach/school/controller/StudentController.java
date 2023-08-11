package jorge.mombach.school.controller;

import jakarta.validation.Valid;
import jorge.mombach.school.dto.StudentDtoRequest;
import jorge.mombach.school.dto.StudentDtoResponse;
import jorge.mombach.school.service.ClassroomService;
import jorge.mombach.school.service.SquadService;
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
    @Autowired
    SquadService squadService;

    @PostMapping("/classroom/{classroomId}/squad/{squadId}/students")
    public ResponseEntity<StudentDtoResponse> createStudentInClassroomAndSquad(
            @PathVariable Long classroomId,
            @PathVariable Long squadId,
            @Valid @RequestBody StudentDtoRequest studentDtoRequest) {

        StudentDtoResponse savedStudent = studentService.createStudentInClassroomAndSquad(classroomId, squadId, studentDtoRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedStudent.getStudent_id())
                .toUri();

        return ResponseEntity.created(location).body(savedStudent);
    }


    @GetMapping("/classroom/{classroomId}/students-with-squads")
    public List<StudentDtoResponse> getStudentsWithSquadsByClassroom(@PathVariable Long classroomId) {
        return studentService.getStudentsWithSquadsByClassroom(classroomId);
    }
}
