package jorge.mombach.school.service;

import jorge.mombach.school.dto.*;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.exception.InsufficientStudentsException;
import jorge.mombach.school.exception.InvalidClassroomStatusException;
import jorge.mombach.school.repository.ClassroomRepository;
import jorge.mombach.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;
    @Autowired
    StudentRepository studentRepository;

    public ClassroomDtoRequest save(ClassroomDtoRequest classroomDtoRequest) {
        if (!classroomDtoRequest.getStatus().equalsIgnoreCase("waiting")) {
            throw new InvalidClassroomStatusException("Invalid initial status for classroom. Only 'waiting' is allowed.");
        }

        Classroom classroom = new Classroom(
                null,
                classroomDtoRequest.getClassroom_name(),
                classroomDtoRequest.getStatus());

        classroomRepository.save(classroom);
        return classroomDtoRequest;
    }

    public List<ClassroomDtoResponse> findAll() {
        List<Classroom> classrooms = classroomRepository.findAll();
        return classrooms.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ClassroomDtoResponse convertToDto(Classroom classroom) {
        return new ClassroomDtoResponse(
                classroom.getId(),
                classroom.getClassroom_name(),
                classroom.getStatus());
    }

    public String updateClassroom(Long id, ClassroomDtoRequest classroomDtoRequest) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + id));

        String newStatus = classroomDtoRequest.getStatus();

        if (!newStatus.equals("waiting") && !newStatus.equals("started") && !newStatus.equals("finished")) {
            throw new InvalidClassroomStatusException("Invalid status: " + newStatus);
        }

        if (newStatus.equals("started")) {
            if (classroom.getStudents().size() < 15) {
                throw new InsufficientStudentsException("At least 15 students are required to start the classroom.");
            }
        } else if (newStatus.equals("finished")) {
            if (!classroom.getStatus().equals("started")) {
                throw new InvalidClassroomStatusException("Classroom must be in 'started' status before it can be finished.");
            }

            throw new InvalidClassroomStatusException("Classroom is already finished and cannot be updated.");
        }

        classroom.setClassroom_name(classroomDtoRequest.getClassroom_name());
        classroom.setStatus(newStatus);

        classroomRepository.save(classroom);
        return "Classroom updated successfully.";
    }


    public void deleteClassroom(Long id) {
        if (classroomRepository.existsById(id)) {
            classroomRepository.deleteById(id);
        }
    }

}

