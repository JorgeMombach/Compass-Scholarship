package jorge.mombach.school.service;

import jorge.mombach.school.dto.StudentDtoRequest;
import jorge.mombach.school.dto.StudentDtoResponse;
import jorge.mombach.school.entity.Student;
import jorge.mombach.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    public StudentDtoRequest save(StudentDtoRequest studentDtoRequest){
        Student student = new Student(
                null,
                studentDtoRequest.getStudent_fname(),
                studentDtoRequest.getStudent_lname());

        studentRepository.save(student);
        return studentDtoRequest;
    }

    public List<StudentDtoResponse> findAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private StudentDtoResponse convertToDto(Student student) {
        return new StudentDtoResponse(
                student.getStudent_id(),
                student.getStudent_fname(),
                student.getStudent_lname()
        );
    }

}
