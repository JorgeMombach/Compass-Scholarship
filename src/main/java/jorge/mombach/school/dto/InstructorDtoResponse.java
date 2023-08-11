package jorge.mombach.school.dto;

public class InstructorDtoResponse {

    private Long instructor_id;
    private String instructor_name;

    public InstructorDtoResponse(Long instructor_id, String instructor_name) {
        this.instructor_id = instructor_id;
        this.instructor_name = instructor_name;
    }

    public Long getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(Long instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }
}
