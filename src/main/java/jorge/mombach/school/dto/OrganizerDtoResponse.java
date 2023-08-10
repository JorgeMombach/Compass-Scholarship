package jorge.mombach.school.dto;

import jorge.mombach.school.entity.OrganizerRole;

public class OrganizerDtoResponse {

    private Long org_id;
    private String org_name;
    private OrganizerRole organizerRole;

    public OrganizerDtoResponse(Long org_id, String org_name, OrganizerRole organizerRole) {
        this.org_id = org_id;
        this.org_name = org_name;
        this.organizerRole = organizerRole;
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

    public OrganizerRole getOrganizerRole() {
        return organizerRole;
    }

    public void setOrganizerRole(OrganizerRole organizerRole) {
        this.organizerRole = organizerRole;
    }
}
