package jorge.mombach.school.dto;

import jorge.mombach.school.entity.OrganizerRole;

public class OrganizerDtoRequest {

    private String org_name;
    private OrganizerRole organizerRole;

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
