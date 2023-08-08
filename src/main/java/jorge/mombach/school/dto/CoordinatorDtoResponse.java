package jorge.mombach.school.dto;

public class CoordinatorDtoResponse {

    private Long coord_id;
    private String name;

    public CoordinatorDtoResponse(Long coord_id, String name) {
        this.coord_id = coord_id;
        this.name = name;
    }

    public Long getCoord_id() {
        return coord_id;
    }

    public void setCoord_id(Long coord_id) {
        this.coord_id = coord_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
