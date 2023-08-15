package jorge.mombach.school.service;

import jorge.mombach.school.dto.ScrumMasterDtoRequest;
import jorge.mombach.school.dto.ScrumMasterDtoResponse;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.entity.ScrumMaster;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.exception.ScrumMasterAlreadyExistsException;
import jorge.mombach.school.repository.ClassroomRepository;
import jorge.mombach.school.repository.ScrumMasterRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ScrumMasterServiceTest {

    @InjectMocks
    private ScrumMasterService scrumMasterService;

    @Mock
    private ScrumMasterRepository scrumMasterRepository;

    @Mock
    private ClassroomRepository classroomRepository;

    @Test
    void createScrumMasterInClassroom() {
        Long classroomId = 1L;
        ScrumMasterDtoRequest scrumMasterDtoRequest = new ScrumMasterDtoRequest();
        scrumMasterDtoRequest.setScrumMaster_name("ScrumMaster1");

        Classroom classroom = new Classroom();

        when(classroomRepository.findById(eq(classroomId))).thenReturn(Optional.of(classroom));
        when(scrumMasterRepository.save(any(ScrumMaster.class))).thenReturn(new ScrumMaster());

        ScrumMasterDtoResponse result = scrumMasterService.createScrumMasterInClassroom(classroomId, scrumMasterDtoRequest);

        assertNotNull(result);
        assertEquals(scrumMasterDtoRequest.getScrumMaster_name(), result.getScrumMaster_name());
    }

    @Test
    void createScrumMasterInClassroomScrumMasterExists() {
        Long classroomId = 1L;
        ScrumMasterDtoRequest scrumMasterDtoRequest = new ScrumMasterDtoRequest();
        scrumMasterDtoRequest.setScrumMaster_name("ScrumMaster1");

        Classroom classroom = new Classroom();
        classroom.setScrumMaster(new ScrumMaster());

        when(classroomRepository.findById(eq(classroomId))).thenReturn(Optional.of(classroom));

        assertThrows(ScrumMasterAlreadyExistsException.class,
                () -> scrumMasterService.createScrumMasterInClassroom(classroomId, scrumMasterDtoRequest));
    }

    @Test
    void createScrumMasterInClassroomClassroomNotFound() {
        Long classroomId = 1L;
        ScrumMasterDtoRequest scrumMasterDtoRequest = new ScrumMasterDtoRequest();
        scrumMasterDtoRequest.setScrumMaster_name("ScrumMaster1");

        when(classroomRepository.findById(eq(classroomId))).thenReturn(Optional.empty());

        assertThrows(ClassroomNotFoundException.class,
                () -> scrumMasterService.createScrumMasterInClassroom(classroomId, scrumMasterDtoRequest));
    }
}