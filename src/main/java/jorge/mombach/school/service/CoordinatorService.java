package jorge.mombach.school.service;

import jorge.mombach.school.dto.*;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.entity.Coordinator;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.exception.CoordinatorAlreadyExistsException;
import jorge.mombach.school.repository.ClassroomRepository;
import jorge.mombach.school.repository.CoordinatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinatorService {

    @Autowired
    private CoordinatorRepository coordinatorRepository;
    @Autowired
    private ClassroomRepository classroomRepository;

    public CoordinatorDtoResponse createCoordinatorInClassroom(Long classroomId, CoordinatorDtoRequest coordinatorDtoRequest) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + classroomId));

        if (classroom.getCoordinator() != null) {
            throw new CoordinatorAlreadyExistsException("A coordinator already exists in the classroom.");
        }

        Coordinator coordinator = new Coordinator();
        coordinator.setCoordinator_name(coordinatorDtoRequest.getCoordinator_name());

        coordinator.setClassroom(classroom);

        coordinatorRepository.save(coordinator);

        return convertCoordinatorToDto(coordinator);
    }

    private CoordinatorDtoResponse convertCoordinatorToDto(Coordinator coordinator) {
        return new CoordinatorDtoResponse(
                coordinator.getCoordinator_id(),
                coordinator.getCoordinator_name()
        );
    }
}
