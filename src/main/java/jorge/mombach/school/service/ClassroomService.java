package jorge.mombach.school.service;

import jorge.mombach.school.dto.*;
import jorge.mombach.school.entity.*;
import jorge.mombach.school.exception.ClassroomNotFoundException;
import jorge.mombach.school.exception.IncompleteOrganizersException;
import jorge.mombach.school.exception.InsufficientStudentsException;
import jorge.mombach.school.exception.InvalidClassroomStatusException;
import jorge.mombach.school.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SquadRepository squadRepository;
    @Autowired
    CoordinatorRepository coordinatorRepository;
    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    ScrumMasterRepository scrumMasterRepository;

    public ClassroomDtoRequest save(ClassroomDtoRequest classroomDtoRequest) {
        if (!classroomDtoRequest.getStatus().equalsIgnoreCase("waiting")) {
            throw new InvalidClassroomStatusException("Invalid initial status for classroom. Only 'waiting' is allowed.");
        }

        Classroom classroom = new Classroom(
                null,
                classroomDtoRequest.getClassroom_name(),
                classroomDtoRequest.getStatus());

        classroomRepository.save(classroom);
        return classroomDtoRequest;
    }

    public List<ClassroomDtoResponse> findAll() {
        List<Classroom> classrooms = classroomRepository.findAll();
        return classrooms.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ClassroomDtoResponse convertToDto(Classroom classroom) {
        return new ClassroomDtoResponse(
                classroom.getId(),
                classroom.getClassroom_name(),
                classroom.getStatus());
    }

    public String updateClassroom(Long id, ClassroomDtoRequest classroomDtoRequest) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + id));

        String newStatus = classroomDtoRequest.getStatus();

        if (!newStatus.equals("waiting") && !newStatus.equals("started") && !newStatus.equals("finished")) {
            throw new InvalidClassroomStatusException("Invalid status: " + newStatus);
        }

        if (classroom.getStatus().equals("finished")) {
            throw new InvalidClassroomStatusException("Classroom is already finished and cannot be updated.");
        }

        if (newStatus.equals("started")) {
            if (classroom.getStudents().size() < 15) {
                throw new InsufficientStudentsException("At least 15 students are required to start the classroom.");
            }

            boolean hasCoordinator = classroom.getCoordinator() != null;
            boolean hasScrumMaster = classroom.getScrumMaster() != null;
            boolean hasEnoughInstructors = classroom.getInstructors().size() >= 3;

            if (!hasCoordinator || !hasScrumMaster || !hasEnoughInstructors) {
                throw new IncompleteOrganizersException("Classroom must have at least 1 Coordinator, 1 Scrum Master, and 3 Instructors to start.");
            }
        } else if (newStatus.equals("finished")) {
            if (!classroom.getStatus().equals("started")) {
                throw new InvalidClassroomStatusException("Classroom must be in 'started' status before it can be finished.");
            }
        }

        classroom.setClassroom_name(classroomDtoRequest.getClassroom_name());
        classroom.setStatus(newStatus);

        classroomRepository.save(classroom);
        return "Classroom updated successfully.";
    }

    public void deleteClassroom(Long id) {
        if (classroomRepository.existsById(id)) {
            classroomRepository.deleteById(id);
        }
    }

    public ClassroomDtoFullResponse getClassroomFullInfo(Long classroomId) {
        Classroom classroom = classroomRepository.findById(classroomId)
                .orElseThrow(() -> new ClassroomNotFoundException("Classroom not found: " + classroomId));

        List<Student> students = classroom.getStudents();
        List<StudentDtoResponse> studentDtos = students.stream()
                .map(this::convertStudentToDtoWithSquad)
                .collect(Collectors.toList());

        List<Squad> squads = classroom.getSquads();
        List<SquadDtoResponse> squadDtos = squads.stream()
                .map(this::convertToSquadDtoResponse)
                .collect(Collectors.toList());

        Coordinator coordinator = classroom.getCoordinator();
        ScrumMaster scrumMaster = classroom.getScrumMaster();
        List<Instructor> instructors = classroom.getInstructors();

        CoordinatorDtoResponse coordinatorDto = coordinator != null ? convertCoordinatorToDto(coordinator) : null;
        ScrumMasterDtoResponse scrumMasterDto = scrumMaster != null ? convertScrumMasterToDto(scrumMaster) : null;
        List<InstructorDtoResponse> instructorDtos = instructors.stream()
                .map(this::convertInstructorToDto)
                .collect(Collectors.toList());


        ClassroomDtoFullResponse classroomDtoFullResponse = new ClassroomDtoFullResponse();
        classroomDtoFullResponse.setId(classroom.getId());
        classroomDtoFullResponse.setClassroom_name(classroom.getClassroom_name());
        classroomDtoFullResponse.setStatus(classroom.getStatus());
        classroomDtoFullResponse.setStudents(studentDtos);
        classroomDtoFullResponse.setSquads(squadDtos);
        classroomDtoFullResponse.setCoordinator(coordinatorDto);
        classroomDtoFullResponse.setScrumMaster(scrumMasterDto);
        classroomDtoFullResponse.setInstructors(instructorDtos);

        return classroomDtoFullResponse;
    }

    private SquadDtoResponse convertToSquadDtoResponse(Squad squad) {
        return new SquadDtoResponse(squad.getId(), squad.getSquad_name());
    }

    private CoordinatorDtoResponse convertCoordinatorToDto(Coordinator coordinator) {
        return new CoordinatorDtoResponse(
                coordinator.getCoordinator_id(),
                coordinator.getCoordinator_name()
        );
    }

    private InstructorDtoResponse convertInstructorToDto(Instructor instructor) {
        return new InstructorDtoResponse(
                instructor.getInstructor_id(),
                instructor.getInstructor_name()
        );
    }

    private ScrumMasterDtoResponse convertScrumMasterToDto(ScrumMaster scrumMaster) {
        return new ScrumMasterDtoResponse(
                scrumMaster.getScrumMaster_id(),
                scrumMaster.getScrumMaster_name()
        );
    }

    private StudentDtoResponse convertStudentToDtoWithSquad(Student student) {
        return new StudentDtoResponse(
                student.getStudent_id(),
                student.getStudent_name(),
                student.getSquad().getSquad_name()
        );
    }
}

