package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COORD_TB")
public class Coordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coord_id;
    private String name;

    public Coordinator() {
    }

    public Coordinator(Long coord_id, String name) {
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

    @Override
    public String toString() {
        return "Coordinator{" +
                "coord_id=" + coord_id +
                ", name='" + name + '\'' +
                '}';
    }
}
