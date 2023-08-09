package jorge.mombach.school.service;

import jorge.mombach.school.dto.StudentDtoRequest;
import jorge.mombach.school.dto.StudentDtoResponse;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.entity.Student;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.repository.ClassroomRepository;
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

    public StudentDtoResponse createStudentInClassroom(Long id, StudentDtoRequest studentDtoRequest) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + id));

        Student student = new Student();
        student.setStudent_name(studentDtoRequest.getStudent_name());
        student.setClassroom(classroom);

        Student savedStudent = studentRepository.save(student);

        return convertStudentToDto(savedStudent);
    }

    private StudentDtoResponse convertStudentToDto(Student student) {
        return new StudentDtoResponse(
                student.getStudent_id(),
                student.getStudent_name()
        );
    }

    public List<StudentDtoResponse> getStudentsByClassroom(Long id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + id));

        List<Student> students = classroom.getStudents();

        return students.stream()
                .map(this::convertStudentToDto)
                .collect(Collectors.toList());
    }



}
