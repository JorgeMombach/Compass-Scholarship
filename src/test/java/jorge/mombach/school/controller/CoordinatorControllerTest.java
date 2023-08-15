package jorge.mombach.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jorge.mombach.school.dto.CoordinatorDtoRequest;
import jorge.mombach.school.dto.CoordinatorDtoResponse;
import jorge.mombach.school.service.ClassroomService;
import jorge.mombach.school.service.CoordinatorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = CoordinatorController.class)
@AutoConfigureMockMvc
class CoordinatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CoordinatorService coordinatorService;

    @MockBean
    private ClassroomService classroomService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void createCoordinatorInClassroom() throws Exception {
        Long classroomId = 1L;
        CoordinatorDtoRequest request = new CoordinatorDtoRequest();
        request.setCoordinator_name("Coordinator1");

        CoordinatorDtoResponse response = new CoordinatorDtoResponse(1L, "Coordinator1");

        when(coordinatorService.createCoordinatorInClassroom(eq(classroomId), any(CoordinatorDtoRequest.class)))
                .thenReturn(response);

        mockMvc.perform(post("/api/v1/classroom/{classroomId}/coordinator", classroomId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.coordinator_id").value(1))
                .andExpect(jsonPath("$.coordinator_name").value("Coordinator1"));
    }
}