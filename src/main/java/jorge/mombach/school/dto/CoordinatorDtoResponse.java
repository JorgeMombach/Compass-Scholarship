package jorge.mombach.school.dto;

public class CoordinatorDtoResponse {

    private Long coordinator_id;
    private String coordinator_name;

    public CoordinatorDtoResponse(Long coordinator_id, String coordinator_name) {
        this.coordinator_id = coordinator_id;
        this.coordinator_name = coordinator_name;
    }

    public Long getCoordinator_id() {
        return coordinator_id;
    }

    public void setCoordinator_id(Long coordinator_id) {
        this.coordinator_id = coordinator_id;
    }

    public String getCoordinator_name() {
        return coordinator_name;
    }

    public void setCoordinator_name(String coordinator_name) {
        this.coordinator_name = coordinator_name;
    }
}
