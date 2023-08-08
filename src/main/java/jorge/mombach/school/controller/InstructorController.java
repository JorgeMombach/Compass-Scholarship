package jorge.mombach.school.controller;

import jorge.mombach.school.dto.InstructorDtoRequest;
import jorge.mombach.school.dto.InstructorDtoResponse;
import jorge.mombach.school.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @PostMapping("/instructor")
    public InstructorDtoRequest saveInstructor(@RequestBody InstructorDtoRequest instructorDtoRequest){
        return instructorService.save(instructorDtoRequest);
    }

    @GetMapping("/instructor")
    public List<InstructorDtoResponse> retrieveAllInstructors(){
        return instructorService.findAll();
    }
}
