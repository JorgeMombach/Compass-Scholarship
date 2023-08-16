package jorge.mombach.school.controller;

import jakarta.validation.Valid;
import jorge.mombach.school.dto.CoordinatorDtoRequest;
import jorge.mombach.school.dto.CoordinatorDtoResponse;
import jorge.mombach.school.service.ClassroomService;
import jorge.mombach.school.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1")
public class CoordinatorController {

    @Autowired
    private CoordinatorService coordinatorService;
    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/classroom/{classroomId}/coordinator")
    public ResponseEntity<CoordinatorDtoResponse> createCoordinatorInClassroom(
            @PathVariable Long classroomId,
            @Valid @RequestBody CoordinatorDtoRequest coordinatorDtoRequest) {

        CoordinatorDtoResponse savedCoordinator = coordinatorService.createCoordinatorInClassroom(classroomId, coordinatorDtoRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedCoordinator.getCoordinator_id())
                .toUri();

        return ResponseEntity.created(location).body(savedCoordinator);
    }
}
