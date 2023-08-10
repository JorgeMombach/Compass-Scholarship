package jorge.mombach.school.controller;

import jakarta.validation.Valid;
import jorge.mombach.school.dto.StudentDtoRequest;
import jorge.mombach.school.dto.StudentDtoResponse;
import jorge.mombach.school.service.ClassroomService;
import jorge.mombach.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1")
public class StudentController {

}
