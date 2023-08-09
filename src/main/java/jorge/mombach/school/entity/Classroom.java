package jorge.mombach.school.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLASS_TB")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String classrom_name;
    private String status;

    @OneToMany(mappedBy = "classroom")
    private List<Student> students;

    @OneToMany(mappedBy = "classroom")
    private List<Organizer> organizers;

    protected Classroom() {
    }

    public Classroom(Long id, String classrom_name, String status) {
        this.id = id;
        this.classrom_name = classrom_name;
        this.status = status;
    }

    public Classroom(Long id, String classrom_name, String status, List<Student> students, List<Organizer> organizers) {
        this.id = id;
        this.classrom_name = classrom_name;
        this.status = status;
        this.students = students;
        this.organizers = organizers;
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

    public List<Organizer> getOrganizers() {
        return organizers;
    }

    public void setOrganizers(List<Organizer> organizers) {
        this.organizers = organizers;
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
