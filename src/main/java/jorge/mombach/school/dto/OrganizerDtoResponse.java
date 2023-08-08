package jorge.mombach.school.dto;

public class OrganizerDtoResponse {

    private Long org_id;
    private String org_name;
    private String org_role;

    public OrganizerDtoResponse(Long org_id, String org_name, String org_role) {
        this.org_id = org_id;
        this.org_name = org_name;
        this.org_role = org_role;
    }

    public Long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public String getOrg_role() {
        return org_role;
    }

    public void setOrg_role(String org_role) {
        this.org_role = org_role;
    }
}
