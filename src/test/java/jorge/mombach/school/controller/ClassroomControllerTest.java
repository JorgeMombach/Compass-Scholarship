package jorge.mombach.school.controller;

import jorge.mombach.school.dto.ClassroomDtoRequest;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.service.ClassroomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jdbc.core.JdbcAggregateOperations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

import static org.hamcrest.Matchers.is;


import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;


@WebMvcTest(controllers = ClassroomController.class)
class ClassroomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClassroomService classroomService;


    @Test
    void saveClassroom() throws Exception{
        ClassroomDtoRequest request = new ClassroomDtoRequest();
        request.setClassroom_name("Test Classroom");
        request.setStatus("waiting");

        ClassroomDtoRequest response = new ClassroomDtoRequest();
        response.setClassroom_name("Test Classroom");
        response.setStatus("waiting");

        when(classroomService.save(any())).thenReturn(response);

        mockMvc.perform(post("/api/v1/classroom")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.classroom_name", is("Test Classroom")))
                .andExpect(jsonPath("$.status", is("waiting")));

        verify(classroomService, times(1)).save(any());


    }

    @Test
    void updateClassroom() throws Exception {
        Long classroomId = 1L;
        ClassroomDtoRequest request = new ClassroomDtoRequest();
        request.setClassroom_name("Updated Classroom");
        request.setStatus("started");

        doReturn("Classroom updated successfully.")
                .when(classroomService)
                .updateClassroom(eq(classroomId), any(ClassroomDtoRequest.class));

        mockMvc.perform(put("/api/v1/classroom/{id}", classroomId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteClassroom() throws Exception {
        Long classroomId = 1L;

        mockMvc.perform(delete("/api/v1/classroom/{id}", classroomId))
                .andExpect(status().isOk());
    }


    private static String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}