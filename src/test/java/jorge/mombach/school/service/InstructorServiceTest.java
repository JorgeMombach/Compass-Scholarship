package jorge.mombach.school.service;

import jorge.mombach.school.dto.InstructorDtoRequest;
import jorge.mombach.school.dto.InstructorDtoResponse;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.entity.Instructor;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.exception.MaximumInstructorsExceededException;
import jorge.mombach.school.repository.ClassroomRepository;
import jorge.mombach.school.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class InstructorServiceTest {

    @InjectMocks
    private InstructorService instructorService;

    @Mock
    private InstructorRepository instructorRepository;

    @Mock
    private ClassroomRepository classroomRepository;

    @Test
    void createInstructorInClassroom() {
        Long classroomId = 1L;
        InstructorDtoRequest instructorDtoRequest = new InstructorDtoRequest();
        instructorDtoRequest.setInstructor_name("Instructor1");

        Classroom classroom = new Classroom();

        when(classroomRepository.findById(eq(classroomId))).thenReturn(Optional.of(classroom));
        when(instructorRepository.save(any(Instructor.class))).thenReturn(new Instructor());

        InstructorDtoResponse result = instructorService.createInstructorInClassroom(classroomId, instructorDtoRequest);

        assertNotNull(result);
        assertEquals(instructorDtoRequest.getInstructor_name(), result.getInstructor_name());
    }

    @Test
    void createInstructorInClassroomMaxExceeded() {
        Long classroomId = 1L;
        InstructorDtoRequest instructorDtoRequest = new InstructorDtoRequest();
        instructorDtoRequest.setInstructor_name("Instructor1");

        Classroom classroom = new Classroom();
        classroom.setInstructors(new ArrayList<>());
        classroom.getInstructors().add(new Instructor());
        classroom.getInstructors().add(new Instructor());
        classroom.getInstructors().add(new Instructor());

        when(classroomRepository.findById(eq(classroomId))).thenReturn(Optional.of(classroom));

        assertThrows(MaximumInstructorsExceededException.class,
                () -> instructorService.createInstructorInClassroom(classroomId, instructorDtoRequest));
    }

    @Test
    void createInstructorInClassroomClassroomNotFound() {
        Long classroomId = 1L;
        InstructorDtoRequest instructorDtoRequest = new InstructorDtoRequest();
        instructorDtoRequest.setInstructor_name("Instructor1");

        when(classroomRepository.findById(eq(classroomId))).thenReturn(Optional.empty());

        assertThrows(ClassroomNotFoundException.class,
                () -> instructorService.createInstructorInClassroom(classroomId, instructorDtoRequest));
    }
}