package jorge.mombach.school.service;

import jorge.mombach.school.dto.InstructorDtoRequest;
import jorge.mombach.school.dto.InstructorDtoResponse;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.entity.Instructor;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.exception.MaximumInstructorsExceededException;
import jorge.mombach.school.repository.ClassroomRepository;
import jorge.mombach.school.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {

    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    ClassroomRepository classroomRepository;

    public InstructorDtoResponse createInstructorInClassroom(Long classroomId, InstructorDtoRequest instructorDtoRequest) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + classroomId));

        if (classroom.getInstructors().size() >= 3) {
            throw new MaximumInstructorsExceededException("Maximum number of instructors in the classroom exceeded. (max: 3)");
        }

        Instructor instructor = new Instructor();
        instructor.setInstructor_name(instructorDtoRequest.getInstructor_name());

        instructor.setClassroom(classroom);

        instructorRepository.save(instructor);

        return convertInstructorToDto(instructor);
    }

    private InstructorDtoResponse convertInstructorToDto(Instructor instructor) {
        return new InstructorDtoResponse(
                instructor.getInstructor_id(),
               instructor.getInstructor_name()
        );
    }
}
