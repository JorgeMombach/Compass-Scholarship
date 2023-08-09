package jorge.mombach.school.service;

import jorge.mombach.school.dto.ClassroomDtoRequest;
import jorge.mombach.school.dto.ClassroomDtoResponse;
import jorge.mombach.school.dto.StudentDtoRequest;
import jorge.mombach.school.dto.StudentDtoResponse;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.entity.Student;
import jorge.mombach.school.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

    public ClassroomDtoRequest save(ClassroomDtoRequest classroomDtoRequest){
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
                classroom.getClassrom_name(),
                classroom.getStatus());
    }

    public String updateClassroom(Long id, ClassroomDtoRequest classroomDtoRequest){
        Classroom classroom = classroomRepository.findById(id).orElse(null);

        if(classroom == null){
            return "Classroom not found.";
        }
        classroom.setClassrom_name(classroomDtoRequest.getClassroom_name());
        classroom.setStatus(classroomDtoRequest.getStatus());

        classroomRepository.save(classroom);
        return "Classroom updated successfully.";
    }

    public void deleteClassroom(Long id) {
        if (classroomRepository.existsById(id)) {
            classroomRepository.deleteById(id);
        }
    }
}
