package jorge.mombach.school.controller;

import jorge.mombach.school.dto.OrganizerDtoRequest;
import jorge.mombach.school.dto.OrganizerDtoResponse;
import jorge.mombach.school.service.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrganizerController {

    @Autowired
    OrganizerService organizerService;

    @PostMapping("/organizer")
    public OrganizerDtoRequest saveOrganizer(@RequestBody OrganizerDtoRequest organizerDtoRequest){
        return organizerService.save(organizerDtoRequest);
    }

    @GetMapping("/organizer")
    public List<OrganizerDtoResponse> retrieveAllOrganizers(){
        return organizerService.findAll();
    }
}
