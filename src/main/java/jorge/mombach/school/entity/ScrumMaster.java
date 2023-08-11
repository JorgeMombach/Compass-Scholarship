package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SCRUMMASTER_TB")
public class ScrumMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scrumMaster_id;

    private String scrumMaster_name;

    @OneToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public ScrumMaster() {
    }

    public ScrumMaster(Long scrumMaster_id, String scrumMaster_name) {
        this.scrumMaster_id = scrumMaster_id;
        this.scrumMaster_name = scrumMaster_name;
    }

    public ScrumMaster(Long scrumMaster_id, String scrumMaster_name, Classroom classroom) {
        this.scrumMaster_id = scrumMaster_id;
        this.scrumMaster_name = scrumMaster_name;
        this.classroom = classroom;
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

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "ScrumMaster{" +
                "scrumMaster_id=" + scrumMaster_id +
                ", scrumMaster_name='" + scrumMaster_name + '\'' +
                '}';
    }
}
