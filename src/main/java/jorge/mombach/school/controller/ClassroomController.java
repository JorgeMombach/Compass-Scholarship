package jorge.mombach.school.controller;

import jorge.mombach.school.dto.*;
import jorge.mombach.school.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @PostMapping("/classroom")
    public ClassroomDtoRequest saveClassroom(@RequestBody ClassroomDtoRequest classroomDtoRequest){
        return classroomService.save(classroomDtoRequest);
    }

    @GetMapping("/classroom")
    public List<ClassroomDtoResponse> retrieveAllClassrooms(){
        return classroomService.findAll();
    }

    @PutMapping("/classroom/{id}")
    public ResponseEntity<String> updateClassroom(@PathVariable Long id, @RequestBody ClassroomDtoRequest classroomDtoRequest){
        String result = classroomService.updateClassroom(id, classroomDtoRequest);

        if(result.equals("Classroom updated successfully.")){
            return ResponseEntity.ok(result);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/classroom/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
        return ResponseEntity.ok().build();
    }

}

