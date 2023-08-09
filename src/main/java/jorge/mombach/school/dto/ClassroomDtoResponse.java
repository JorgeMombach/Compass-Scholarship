package jorge.mombach.school.dto;

public class ClassroomDtoResponse {

    private Long id;
    private String classroom_name;
    private String status;

    public ClassroomDtoResponse(Long id, String classroom_name, String status) {
        this.id = id;
        this.classroom_name = classroom_name;
        this.status = status;
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
}
