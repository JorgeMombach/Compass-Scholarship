package jorge.mombach.school.dto;

public class InstructorDtoResponse {

    private Long inst_id;
    private String inst_name;

    public InstructorDtoResponse(Long inst_id, String inst_name) {
        this.inst_id = inst_id;
        this.inst_name = inst_name;
    }

    public Long getInst_id() {
        return inst_id;
    }

    public void setInst_id(Long inst_id) {
        this.inst_id = inst_id;
    }

    public String getInst_name() {
        return inst_name;
    }

    public void setInst_name(String inst_name) {
        this.inst_name = inst_name;
    }
}
