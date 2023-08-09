package jorge.mombach.school.controller;

import jorge.mombach.school.dto.ClassroomDtoRequest;
import jorge.mombach.school.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @PostMapping("/classroom")
    public ClassroomDtoRequest saveClassroom(@RequestBody ClassroomDtoRequest classroomDtoRequest){
        return classroomService.save(classroomDtoRequest);
    }
}
