package jorge.mombach.school.dto;

public class SquadDtoResponse {

    private Long id;
    private String squad_name;

    public SquadDtoResponse(Long id, String squad_name) {
        this.id = id;
        this.squad_name = squad_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSquad_name() {
        return squad_name;
    }

    public void setSquad_name(String squad_name) {
        this.squad_name = squad_name;
    }
}
