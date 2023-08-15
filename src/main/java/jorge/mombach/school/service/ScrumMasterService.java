package jorge.mombach.school.service;

import jorge.mombach.school.dto.ScrumMasterDtoRequest;
import jorge.mombach.school.dto.ScrumMasterDtoResponse;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.entity.ScrumMaster;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.exception.ScrumMasterAlreadyExistsException;
import jorge.mombach.school.repository.ClassroomRepository;
import jorge.mombach.school.repository.ScrumMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScrumMasterService {

    @Autowired
    ScrumMasterRepository scrumMasterRepository;
    @Autowired
    ClassroomRepository classroomRepository;

    public ScrumMasterDtoResponse createScrumMasterInClassroom(Long classroomId, ScrumMasterDtoRequest scrumMasterDtoRequest) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + classroomId));

        if (classroom.getScrumMaster() != null) {
            throw new ScrumMasterAlreadyExistsException("A Scrum Master already exists in the classroom.");
        }

        ScrumMaster scrumMaster = new ScrumMaster();
        scrumMaster.setScrumMaster_name(scrumMasterDtoRequest.getScrumMaster_name());

        scrumMaster.setClassroom(classroom);

        scrumMasterRepository.save(scrumMaster);

        return convertScrumMasterToDto(scrumMaster);
    }

    private ScrumMasterDtoResponse convertScrumMasterToDto(ScrumMaster scrumMaster) {
        return new ScrumMasterDtoResponse(
                scrumMaster.getScrumMaster_id(),
                scrumMaster.getScrumMaster_name()
        );
    }
}
