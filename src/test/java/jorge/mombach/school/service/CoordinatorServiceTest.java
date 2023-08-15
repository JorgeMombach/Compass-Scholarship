package jorge.mombach.school.service;

import jorge.mombach.school.dto.CoordinatorDtoRequest;
import jorge.mombach.school.dto.CoordinatorDtoResponse;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.entity.Coordinator;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.exception.CoordinatorAlreadyExistsException;
import jorge.mombach.school.repository.ClassroomRepository;
import jorge.mombach.school.repository.CoordinatorRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CoordinatorServiceTest {

    @InjectMocks
    private CoordinatorService coordinatorService;

    @Mock
    private CoordinatorRepository coordinatorRepository;

    @Mock
    private ClassroomRepository classroomRepository;

    @Test
    void createCoordinatorInClassroom() {
        Long classroomId = 1L;
        CoordinatorDtoRequest coordinatorDtoRequest = new CoordinatorDtoRequest();
        coordinatorDtoRequest.setCoordinator_name("Coordinator1");

        Classroom classroom = new Classroom();

        when(classroomRepository.findById(eq(classroomId))).thenReturn(Optional.of(classroom));
        when(coordinatorRepository.save(any(Coordinator.class))).thenReturn(new Coordinator());

        CoordinatorDtoResponse result = coordinatorService.createCoordinatorInClassroom(classroomId, coordinatorDtoRequest);

        assertNotNull(result);
        assertEquals(coordinatorDtoRequest.getCoordinator_name(), result.getCoordinator_name());
    }

    @Test
    void createCoordinatorInClassroomCoordinatorExists() {
        Long classroomId = 1L;
        CoordinatorDtoRequest coordinatorDtoRequest = new CoordinatorDtoRequest();
        coordinatorDtoRequest.setCoordinator_name("Coordinator1");

        Classroom classroom = new Classroom();
        classroom.setCoordinator(new Coordinator());

        when(classroomRepository.findById(eq(classroomId))).thenReturn(Optional.of(classroom));

        assertThrows(CoordinatorAlreadyExistsException.class,
                () -> coordinatorService.createCoordinatorInClassroom(classroomId, coordinatorDtoRequest));
    }

    @Test
    void createCoordinatorInClassroomClassroomNotFound() {
        Long classroomId = 1L;
        CoordinatorDtoRequest coordinatorDtoRequest = new CoordinatorDtoRequest();
        coordinatorDtoRequest.setCoordinator_name("John Doe");

        when(classroomRepository.findById(eq(classroomId))).thenReturn(Optional.empty());

        assertThrows(ClassroomNotFoundException.class,
                () -> coordinatorService.createCoordinatorInClassroom(classroomId, coordinatorDtoRequest));
    }
}