package jorge.mombach.school.service;

import jorge.mombach.school.dto.ClassroomDtoRequest;
import jorge.mombach.school.entity.*;
import jorge.mombach.school.repository.ClassroomRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ClassroomServiceTest {

    @InjectMocks
    private ClassroomService classroomService;
    @Mock
    private ClassroomRepository classroomRepository;

    @Test
    void save() {
        ClassroomDtoRequest classroomDtoRequest = new ClassroomDtoRequest();
        classroomDtoRequest.setClassroom_name("Test Classroom");
        classroomDtoRequest.setStatus("waiting");

        Classroom classroom = new Classroom();
        classroom.setClassroom_name(classroomDtoRequest.getClassroom_name());
        classroom.setStatus(classroomDtoRequest.getStatus());

        when(classroomRepository.save(any(Classroom.class))).thenReturn(classroom);

        ClassroomDtoRequest result = classroomService.save(classroomDtoRequest);

        assertEquals(classroomDtoRequest, result);
    }


    @Test
    void updateClassroom() {
        Long classroomId = 1L;
        ClassroomDtoRequest classroomDtoRequest = new ClassroomDtoRequest();
        classroomDtoRequest.setStatus("started");

        Classroom classroom = new Classroom();
        classroom.setStatus("waiting");

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            students.add(new Student());
        }
        classroom.setStudents(students);

        classroom.setCoordinator(new Coordinator());
        classroom.setScrumMaster(new ScrumMaster());

        List<Instructor> instructors = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            instructors.add(new Instructor());
        }
        classroom.setInstructors(instructors);


        when(classroomRepository.findById(eq(classroomId))).thenReturn(Optional.of(classroom));
        when(classroomRepository.save(any(Classroom.class))).thenReturn(classroom);

        String result = classroomService.updateClassroom(classroomId, classroomDtoRequest);

        assertEquals("Classroom updated successfully.", result);
    }

    @Test
    void deleteClassroom() {
        Long classroomId = 1L;

        when(classroomRepository.existsById(eq(classroomId))).thenReturn(true);

        classroomService.deleteClassroom(classroomId);

        verify(classroomRepository, times(1)).deleteById(eq(classroomId));
    }

}