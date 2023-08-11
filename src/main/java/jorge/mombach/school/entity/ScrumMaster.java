package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SCRUMMASTER_TB")
public class ScrumMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ScrumMasterId;

    private String name;

    @OneToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public ScrumMaster() {
    }

    public ScrumMaster(Long scrumMasterId, String name) {
        ScrumMasterId = scrumMasterId;
        this.name = name;
    }

    public ScrumMaster(Long scrumMasterId, String name, Classroom classroom) {
        ScrumMasterId = scrumMasterId;
        this.name = name;
        this.classroom = classroom;
    }

    public Long getScrumMasterId() {
        return ScrumMasterId;
    }

    public void setScrumMasterId(Long scrumMasterId) {
        ScrumMasterId = scrumMasterId;
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
        return "ScrumMaster{" +
                "ScrumMasterId=" + ScrumMasterId +
                ", name='" + name + '\'' +
                '}';
    }
}
