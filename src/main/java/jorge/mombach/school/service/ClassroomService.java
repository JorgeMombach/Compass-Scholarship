package jorge.mombach.school.service;

import jorge.mombach.school.dto.ClassroomDtoRequest;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

    public ClassroomDtoRequest save(ClassroomDtoRequest classroomDtoRequest){
        Classroom classroom = new Classroom(
                null,
                classroomDtoRequest.getClassroom_name());

        classroomRepository.save(classroom);
        return classroomDtoRequest;
    }
}
