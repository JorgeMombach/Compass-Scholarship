package jorge.mombach.school.service;

import jorge.mombach.school.dto.SquadDtoRequest;
import jorge.mombach.school.entity.Squad;
import jorge.mombach.school.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SquadService {

    @Autowired
    SquadRepository squadRepository;

    public SquadDtoRequest save(SquadDtoRequest squadDtoRequest){
        Squad squad = new Squad(
                null,
                squadDtoRequest.getSquad_name());

        squadRepository.save(squad);
        return squadDtoRequest;
    }
}
