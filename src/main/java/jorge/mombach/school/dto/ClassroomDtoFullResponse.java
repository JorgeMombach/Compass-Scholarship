package jorge.mombach.school.dto;

import java.util.List;

public class ClassroomDtoFullResponse {

    private Long id;
    private String classroom_name;
    private String status;
    private List<StudentDtoResponse> students;
    private List<SquadDtoResponse> squads;
    private CoordinatorDtoResponse coordinator;
    private ScrumMasterDtoResponse scrumMaster;
    private List<InstructorDtoResponse> instructors;


    public ClassroomDtoFullResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassroom_name() {
        return classroom_name;
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name = classroom_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StudentDtoResponse> getStudents() {
        return students;
    }

    public void setStudents(List<StudentDtoResponse> students) {
        this.students = students;
    }

    public List<SquadDtoResponse> getSquads() {
        return squads;
    }

    public void setSquads(List<SquadDtoResponse> squads) {
        this.squads = squads;
    }

    public CoordinatorDtoResponse getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(CoordinatorDtoResponse coordinator) {
        this.coordinator = coordinator;
    }

    public ScrumMasterDtoResponse getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(ScrumMasterDtoResponse scrumMaster) {
        this.scrumMaster = scrumMaster;
    }

    public List<InstructorDtoResponse> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<InstructorDtoResponse> instructors) {
        this.instructors = instructors;
    }
}
