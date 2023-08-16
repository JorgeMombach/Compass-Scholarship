package jorge.mombach.school.controller;

import jakarta.validation.Valid;
import jorge.mombach.school.dto.ScrumMasterDtoRequest;
import jorge.mombach.school.dto.ScrumMasterDtoResponse;
import jorge.mombach.school.service.ClassroomService;
import jorge.mombach.school.service.ScrumMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/v1")
public class ScrumMasterController {

    @Autowired
    private ScrumMasterService scrumMasterService;
    @Autowired
    private ClassroomService classroomService;

    @PostMapping("/classroom/{classroomId}/scrumMaster")
    public ResponseEntity<ScrumMasterDtoResponse> createScrumMasterInClassroom(
            @PathVariable Long classroomId,
            @Valid @RequestBody ScrumMasterDtoRequest scrumMasterDtoRequest) {

        ScrumMasterDtoResponse savedScrumMaster = scrumMasterService.createScrumMasterInClassroom(classroomId, scrumMasterDtoRequest);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedScrumMaster.getScrumMaster_id())
                .toUri();

        return ResponseEntity.created(location).body(savedScrumMaster);
    }
}
