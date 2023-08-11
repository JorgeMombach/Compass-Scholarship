package jorge.mombach.school.dto;

public class ScrumMasterDtoResponse {

    private Long scrumMaster_id;
    private String scrumMaster_name;

    public ScrumMasterDtoResponse(Long scrumMaster_id, String scrumMaster_name) {
        this.scrumMaster_id = scrumMaster_id;
        this.scrumMaster_name = scrumMaster_name;
    }

    public Long getScrumMaster_id() {
        return scrumMaster_id;
    }

    public void setScrumMaster_id(Long scrumMaster_id) {
        this.scrumMaster_id = scrumMaster_id;
    }

    public String getScrumMaster_name() {
        return scrumMaster_name;
    }

    public void setScrumMaster_name(String scrumMaster_name) {
        this.scrumMaster_name = scrumMaster_name;
    }
}
