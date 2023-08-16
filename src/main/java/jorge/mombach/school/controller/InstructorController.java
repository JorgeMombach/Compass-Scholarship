package jorge.mombach.school.controller;

import jakarta.validation.Valid;
import jorge.mombach.school.dto.CoordinatorDtoRequest;
import jorge.mombach.school.dto.CoordinatorDtoResponse;
import jorge.mombach.school.dto.InstructorDtoRequest;
import jorge.mombach.school.dto.InstructorDtoResponse;
import jorge.mombach.school.service.ClassroomService;
import jorge.mombach.school.service.CoordinatorService;
import jorge.mombach.school.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;
    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/classroom/{classroomId}/instructor")
    public ResponseEntity<InstructorDtoResponse> createInstructorInClassroom(
            @PathVariable Long classroomId,
            @Valid @RequestBody InstructorDtoRequest instructorDtoRequest) {

        InstructorDtoResponse savedInstructor = instructorService.createInstructorInClassroom(classroomId, instructorDtoRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedInstructor.getInstructor_id())
                .toUri();

        return ResponseEntity.created(location).body(savedInstructor);
    }
}
