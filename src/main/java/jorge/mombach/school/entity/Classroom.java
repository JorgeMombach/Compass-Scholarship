package jorge.mombach.school.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

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

    @OneToOne(mappedBy = "classroom")
    private Coordinator coordinator;

    @OneToMany(mappedBy = "classroom")
    private List<Instructor> instructors = new ArrayList<>();

    @OneToOne(mappedBy = "classroom")
    private ScrumMaster scrumMaster;

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

    public Classroom(Long id, String classroom_name, String status, List<Student> students, List<Squad> squads, Coordinator coordinator) {
        this.id = id;
        this.classroom_name = classroom_name;
        this.status = status;
        this.students = students;
        this.squads = squads;
        this.coordinator = coordinator;
    }

    public Classroom(Long id, String classroom_name, String status, List<Student> students, List<Squad> squads, Coordinator coordinator, List<Instructor> instructors) {
        this.id = id;
        this.classroom_name = classroom_name;
        this.status = status;
        this.students = students;
        this.squads = squads;
        this.coordinator = coordinator;
        this.instructors = instructors;
    }

    public Classroom(Long id, String classroom_name, String status, List<Student> students, List<Squad> squads, Coordinator coordinator, List<Instructor> instructors, ScrumMaster scrumMaster) {
        this.id = id;
        this.classroom_name = classroom_name;
        this.status = status;
        this.students = students;
        this.squads = squads;
        this.coordinator = coordinator;
        this.instructors = instructors;
        this.scrumMaster = scrumMaster;
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

    public Coordinator getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Coordinator coordinator) {
        this.coordinator = coordinator;
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public ScrumMaster getScrumMaster() {
        return scrumMaster;
    }

    public void setScrumMaster(ScrumMaster scrumMaster) {
        this.scrumMaster = scrumMaster;
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
