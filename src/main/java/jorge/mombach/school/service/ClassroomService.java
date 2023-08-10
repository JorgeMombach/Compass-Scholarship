package jorge.mombach.school.service;

import jorge.mombach.school.dto.*;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.entity.Squad;
import jorge.mombach.school.entity.Student;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.exception.SquadNotFoundException;
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
                classroom.getClassroom_name(),
                classroom.getStatus());
    }

    public String updateClassroom(Long id, ClassroomDtoRequest classroomDtoRequest){
        Classroom classroom = classroomRepository.findById(id).orElse(null);

        if(classroom == null){
            return "Classroom not found.";
        }
        classroom.setClassroom_name(classroomDtoRequest.getClassroom_name());
        classroom.setStatus(classroomDtoRequest.getStatus());

        classroomRepository.save(classroom);
        return "Classroom updated successfully.";
    }

    public void deleteClassroom(Long id) {
        if (classroomRepository.existsById(id)) {
            classroomRepository.deleteById(id);
        }
    }

    public StudentDtoResponse createStudentInClassroomAndSquad(Long classroomId, Long squadId, StudentDtoRequest studentDtoRequest) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + classroomId));

        Squad squad = classroom.getSquads().stream()
                .filter(s -> s.getId().equals(squadId))
                .findFirst()
                .orElseThrow(() -> new SquadNotFoundException("Squad not found in the specified classroom"));

        Student student = new Student();
        student.setStudent_name(studentDtoRequest.getStudent_name());

        student.setClassroom(classroom);
        student.setSquad(squad);

        studentRepository.save(student);

        return convertStudentToDto(student);
    }

    private StudentDtoResponse convertStudentToDto(Student student) {
        return new StudentDtoResponse(
                student.getStudent_id(),
                student.getStudent_name()
        );
    }

    public List<StudentDtoResponse> getStudentsWithSquadsByClassroom(Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + classroomId));

        List<Student> students = classroom.getStudents();

        return students.stream()
                .map(this::convertStudentToDtoWithSquad)
                .collect(Collectors.toList());
    }

    private StudentDtoResponse convertStudentToDtoWithSquad(Student student) {
        return new StudentDtoResponse(
                student.getStudent_id(),
                student.getStudent_name(),
                student.getSquad().getSquad_name()
        );
    }

}

