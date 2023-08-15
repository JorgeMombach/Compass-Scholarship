package jorge.mombach.school.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jorge.mombach.school.dto.InstructorDtoRequest;
import jorge.mombach.school.dto.InstructorDtoResponse;
import jorge.mombach.school.service.ClassroomService;
import jorge.mombach.school.service.InstructorService;
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

@WebMvcTest(controllers = InstructorController.class)
@AutoConfigureMockMvc
class InstructorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstructorService instructorService;

    @MockBean
    private ClassroomService classroomService;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void createInstructorInClassroom() throws Exception {
        Long classroomId = 1L;
        InstructorDtoRequest request = new InstructorDtoRequest();
        request.setInstructor_name("Instructor1");

        InstructorDtoResponse response = new InstructorDtoResponse(1L, "Instructor1");

        when(instructorService.createInstructorInClassroom(eq(classroomId), any(InstructorDtoRequest.class)))
                .thenReturn(response);

        mockMvc.perform(post("/api/v1/classroom/{classroomId}/instructor", classroomId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.instructor_id").value(1))
                .andExpect(jsonPath("$.instructor_name").value("Instructor1"));
    }
}