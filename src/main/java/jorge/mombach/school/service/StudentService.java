package jorge.mombach.school.service;

import jorge.mombach.school.dto.StudentDtoRequest;
import jorge.mombach.school.dto.StudentDtoResponse;
import jorge.mombach.school.entity.Student;
import jorge.mombach.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {


    @Autowired
    StudentRepository studentRepository;

    public String save(StudentDtoRequest studentDtoRequest){
        Student student = new Student(
                null,
                studentDtoRequest.getStudent_fname(),
                studentDtoRequest.getStudent_lname());

        studentRepository.save(student);
        return "Student added";
    }

//    public StudentDtoResponse findAll() {
//        studentRepository.findAll();
//        return (StudentDtoResponse) students;
//    }
}
