package jorge.mombach.school.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CLASSROOM_TB")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classroom_name;
    private String status;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Squad> squads = new ArrayList<>();

    protected Classroom() {
    }

    public Classroom(Long id, String classroom_name, String status) {
        this.id = id;
        this.classroom_name = classroom_name;
        this.status = status;
    }

    public Classroom(Long id, String classroom_name, String status, List<Student> students) {
        this.id = id;
        this.classroom_name = classroom_name;
        this.status = status;
        this.students = students;
    }

    public Classroom(Long id, String classroom_name, String status, List<Student> students, List<Squad> squads) {
        this.id = id;
        this.classroom_name = classroom_name;
        this.status = status;
        this.students = students;
        this.squads = squads;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassroom_name() {
        return classroom_name;
    }

    public void setClassroom_name(String classroom_name) {
        this.classroom_name = classroom_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Squad> getSquads() {
        return squads;
    }

    public void setSquads(List<Squad> squads) {
        this.squads = squads;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", classroom_name='" + classroom_name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
