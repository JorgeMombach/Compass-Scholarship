package jorge.mombach.school.controller;

import jakarta.validation.Valid;
import jorge.mombach.school.dto.SquadDtoRequest;
import jorge.mombach.school.dto.SquadDtoResponse;
import jorge.mombach.school.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
public class SquadController {

    @Autowired
    SquadService squadService;

    @PostMapping("/classroom/{classroomId}/squads")
    public ResponseEntity<SquadDtoResponse> createSquadInClassroom(
            @PathVariable Long classroomId,
            @Valid @RequestBody SquadDtoRequest squadDtoRequest) {

        SquadDtoResponse savedSquad = squadService.createSquadInClassroom(classroomId, squadDtoRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedSquad.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedSquad);
    }
}
