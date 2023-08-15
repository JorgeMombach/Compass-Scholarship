package jorge.mombach.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jorge.mombach.school.dto.ScrumMasterDtoRequest;
import jorge.mombach.school.dto.ScrumMasterDtoResponse;
import jorge.mombach.school.service.ClassroomService;
import jorge.mombach.school.service.ScrumMasterService;
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

@WebMvcTest(controllers = ScrumMasterController.class)
@AutoConfigureMockMvc
class ScrumMasterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScrumMasterService scrumMasterService;

    @MockBean
    private ClassroomService classroomService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void createScrumMasterInClassroom() throws Exception {
        Long classroomId = 1L;
        ScrumMasterDtoRequest request = new ScrumMasterDtoRequest();
        request.setScrumMaster_name("ScrumMaster1");

        ScrumMasterDtoResponse response = new ScrumMasterDtoResponse(1L, "ScrumMaster1");

        when(scrumMasterService.createScrumMasterInClassroom(eq(classroomId), any(ScrumMasterDtoRequest.class)))
                .thenReturn(response);

        mockMvc.perform(post("/api/v1/classroom/{classroomId}/scrumMaster", classroomId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.scrumMaster_id").value(1))
                .andExpect(jsonPath("$.scrumMaster_name").value("ScrumMaster1"));
    }
}