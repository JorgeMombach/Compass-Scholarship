package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COORDINATOR_TB")
public class Coordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CoordinatorId;

    private String name;

    @OneToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Coordinator() {
    }

    public Coordinator(Long coordinatorId, String name) {
        CoordinatorId = coordinatorId;
        this.name = name;
    }

    public Coordinator(Long coordinatorId, String name, Classroom classroom) {
        CoordinatorId = coordinatorId;
        this.name = name;
        this.classroom = classroom;
    }

    public Long getCoordinatorId() {
        return CoordinatorId;
    }

    public void setCoordinatorId(Long coordinatorId) {
        CoordinatorId = coordinatorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "CoordinatorId=" + CoordinatorId +
                ", name='" + name + '\'' +
                '}';
    }
}
