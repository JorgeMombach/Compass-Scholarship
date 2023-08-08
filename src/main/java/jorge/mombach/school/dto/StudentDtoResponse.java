package jorge.mombach.school.dto;

public class StudentDtoResponse {

    private Long student_id;
    private String student_fname;
    private String student_lname;

    public StudentDtoResponse(Long student_id, String student_fname, String student_lname) {
        this.student_id = student_id;
        this.student_fname = student_fname;
        this.student_lname = student_lname;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_fname() {
        return student_fname;
    }

    public void setStudent_fname(String student_fname) {
        this.student_fname = student_fname;
    }

    public String getStudent_lname() {
        return student_lname;
    }

    public void setStudent_lname(String student_lname) {
        this.student_lname = student_lname;
    }
}
