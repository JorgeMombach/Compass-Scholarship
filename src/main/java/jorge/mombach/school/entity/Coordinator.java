package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COORDINATOR_TB")
public class Coordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coordinator_id;

    private String coordinator_name;

    @OneToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Coordinator() {
    }

    public Coordinator(Long coordinator_id, String coordinator_name) {
        this.coordinator_id = coordinator_id;
        this.coordinator_name = coordinator_name;
    }

    public Coordinator(Long coordinator_id, String coordinator_name, Classroom classroom) {
        this.coordinator_id = coordinator_id;
        this.coordinator_name = coordinator_name;
        this.classroom = classroom;
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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Coordinator{" +
                "coordinator_id=" + coordinator_id +
                ", coordinator_name='" + coordinator_name + '\'' +
                '}';
    }
}
