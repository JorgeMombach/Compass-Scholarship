package jorge.mombach.school.service;

import jorge.mombach.school.dto.CoordinatorDtoRequest;
import jorge.mombach.school.dto.CoordinatorDtoResponse;
import jorge.mombach.school.entity.Coordinator;
import jorge.mombach.school.repository.CoordinatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoordinatorService {

    @Autowired
    CoordinatorRepository coordinatorRepository;

    public CoordinatorDtoRequest save(CoordinatorDtoRequest coordinatorDtoRequest){
        Coordinator coordinator = new Coordinator(
                null,
                coordinatorDtoRequest.getName());

        coordinatorRepository.save(coordinator);
        return coordinatorDtoRequest;
    }

    public List<CoordinatorDtoResponse> findAll() {
        List<Coordinator> coordinators = coordinatorRepository.findAll();
        return coordinators.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CoordinatorDtoResponse convertToDto(Coordinator coordinator) {
        return new CoordinatorDtoResponse(
                coordinator.getCoord_id(),
                coordinator.getName());
    }
}
