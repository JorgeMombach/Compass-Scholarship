package jorge.mombach.school.controller;

import jorge.mombach.school.dto.CoordinatorDtoRequest;
import jorge.mombach.school.dto.CoordinatorDtoResponse;
import jorge.mombach.school.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CoordinatorController {

    @Autowired
    CoordinatorService coordinatorService;

    @PostMapping("coordinator")
    public CoordinatorDtoRequest saveCoordinator(@RequestBody CoordinatorDtoRequest coordinatorDtoRequest){
        return coordinatorService.save(coordinatorDtoRequest);
    }

    @GetMapping("/coordinator")
    public List<CoordinatorDtoResponse> retrieveAllCoordinators(){
        return coordinatorService.findAll();
    }
}
