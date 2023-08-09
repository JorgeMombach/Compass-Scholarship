package jorge.mombach.school.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="SQUAD_TB")
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String squad_name;

    @OneToMany(mappedBy = "squad")
    private List<Student> students;

    protected Squad(){
    }

    public Squad(Long id, String squad_name) {
        this.id = id;
        this.squad_name = squad_name;
    }

    public Squad(Long id, String squad_name, List<Student> students) {
        this.id = id;
        this.squad_name = squad_name;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Squad{" +
                "id=" + id +
                ", squad_name='" + squad_name + '\'' +
                '}';
    }
}
