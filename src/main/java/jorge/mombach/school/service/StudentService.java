package jorge.mombach.school.service;

import jorge.mombach.school.dto.StudentDtoRequest;
import jorge.mombach.school.dto.StudentDtoResponse;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.entity.Squad;
import jorge.mombach.school.entity.Student;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.exception.InvalidClassroomStatusException;
import jorge.mombach.school.exception.MaximumStudentsExceededException;
import jorge.mombach.school.exception.SquadNotFoundException;
import jorge.mombach.school.repository.ClassroomRepository;
import jorge.mombach.school.repository.SquadRepository;
import jorge.mombach.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ClassroomRepository classroomRepository;
    @Autowired
    SquadRepository squadRepository;

    public StudentDtoResponse createStudentInClassroomAndSquad(Long classroomId, Long squadId, StudentDtoRequest studentDtoRequest) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + classroomId));

        Squad squad = classroom.getSquads().stream()
                .filter(s -> s.getId().equals(squadId))
                .findFirst()
                .orElseThrow(() -> new SquadNotFoundException("Squad not found in the specified classroom"));

        String classroomStatus = classroom.getStatus();

        if (!classroomStatus.equals("waiting")) {
            throw new InvalidClassroomStatusException("Cannot add a new student when the classroom status is: " + classroomStatus);
        }

        if (classroom.getStudents().size() >= 30) {
            throw new MaximumStudentsExceededException("Maximum number of students in the classroom exceeded. (max: 30)");
        }

        if (squad.getStudents().size() >= 5) {
            throw new MaximumStudentsExceededException("Maximum number of students in the squad exceeded (max: 5). Consider creating a new Squad.");
        }

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
