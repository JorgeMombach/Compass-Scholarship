package jorge.mombach.school.service;

import jorge.mombach.school.dto.InstructorDtoRequest;
import jorge.mombach.school.dto.InstructorDtoResponse;
import jorge.mombach.school.entity.Instructor;
import jorge.mombach.school.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstructorService {

    @Autowired
    InstructorRepository instructorRepository;

    public InstructorDtoRequest save(InstructorDtoRequest instructorDtoRequest){
        Instructor instructor = new Instructor(
                null,
                instructorDtoRequest.getInst_name());

        instructorRepository.save(instructor);
        return instructorDtoRequest;
    }

    public List<InstructorDtoResponse> findAll(){
        List<Instructor> instructors = instructorRepository.findAll();
        return instructors.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private InstructorDtoResponse convertToDto(Instructor instructor){
        return new InstructorDtoResponse(
                instructor.getInst_id(),
                instructor.getInst_name());
    }
}
