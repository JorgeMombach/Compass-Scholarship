package jorge.mombach.school.service;

import jorge.mombach.school.dto.SquadDtoRequest;
import jorge.mombach.school.dto.SquadDtoResponse;
import jorge.mombach.school.entity.Classroom;
import jorge.mombach.school.entity.Squad;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.repository.ClassroomRepository;
import jorge.mombach.school.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SquadService {

    @Autowired
    SquadRepository squadRepository;
    @Autowired
    ClassroomRepository classroomRepository;

    public SquadDtoResponse createSquadInClassroom(Long classroomId, SquadDtoRequest squadDtoRequest) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + classroomId));

        Squad squad = new Squad();
        squad.setSquad_name(squadDtoRequest.getSquad_name());
        squad.setClassroom(classroom);

        Squad savedSquad = squadRepository.save(squad);
        return convertToSquadDtoResponse(savedSquad);
    }

    private SquadDtoResponse convertToSquadDtoResponse(Squad squad) {
        return new SquadDtoResponse(squad.getId(), squad.getSquad_name());
    }
}
