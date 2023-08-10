package jorge.mombach.school.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLASSROOM_TB")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classrom_name;
    private String status;

    @OneToMany(mappedBy = "classroom")
    private List<Student> students;

    @OneToMany(mappedBy = "classroom")
    private List<Squad> squads;

    @ManyToMany
    @JoinTable(name= "CLASSROOM_ORGANIZER",
            joinColumns = @JoinColumn(name="classroom_id"),
            inverseJoinColumns = @JoinColumn(name = "organizer_id"))
    private List<Organizer> organizers;

    protected Classroom() {
    }

    public Classroom(Long id, String classrom_name, String status) {
        this.id = id;
        this.classrom_name = classrom_name;
        this.status = status;
    }

    public Classroom(Long id, String classrom_name, String status, List<Student> students) {
        this.id = id;
        this.classrom_name = classrom_name;
        this.status = status;
        this.students = students;
    }

    public Classroom(Long id, String classrom_name, String status, List<Student> students, List<Squad> squads) {
        this.id = id;
        this.classrom_name = classrom_name;
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

    public String getClassrom_name() {
        return classrom_name;
    }

    public void setClassrom_name(String classrom_name) {
        this.classrom_name = classrom_name;
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
                ", classrom_name='" + classrom_name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
