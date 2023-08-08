package jorge.mombach.school.service;

import jorge.mombach.school.dto.OrganizerDtoRequest;
import jorge.mombach.school.dto.OrganizerDtoResponse;
import jorge.mombach.school.entity.Organizer;
import jorge.mombach.school.repository.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizerService {

    @Autowired
    OrganizerRepository organizerRepository;

    public OrganizerDtoRequest save(OrganizerDtoRequest organizerDtoRequest){
        Organizer organizer = new Organizer(
                null,
                organizerDtoRequest.getOrg_name(),
                organizerDtoRequest.getOrg_role());

        organizerRepository.save(organizer);
        return organizerDtoRequest;
    }

    public List<OrganizerDtoResponse> findAll() {
        List<Organizer> organizers = organizerRepository.findAll();
        return organizers.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private OrganizerDtoResponse convertToDto(Organizer organizer) {
        return new OrganizerDtoResponse(
                organizer.getOrg_id(),
                organizer.getOrg_name(),
                organizer.getOrg_role());
    }
}
