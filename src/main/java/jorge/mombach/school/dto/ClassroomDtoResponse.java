package jorge.mombach.school.dto;

public class ClassroomDtoResponse {

    private Long id;
    private String classroom_name;

    public ClassroomDtoResponse(Long id, String classroom_name) {
        this.id = id;
        this.classroom_name = classroom_name;
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
}
