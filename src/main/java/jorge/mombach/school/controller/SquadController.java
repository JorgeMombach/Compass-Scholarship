package jorge.mombach.school.controller;

import jorge.mombach.school.dto.SquadDtoRequest;
import jorge.mombach.school.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SquadController {

    @Autowired
    SquadService squadService;

    @PostMapping("/squad")
    public SquadDtoRequest saveSquad(@RequestBody SquadDtoRequest squadDtoRequest){
        return squadService.save(squadDtoRequest);
    }
}
