package jorge.mombach.school.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLASS_TB")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "classroom")
    @JsonIgnore
    private List<Student> students;

    @OneToMany(mappedBy = "classroom")
    @JsonIgnore
    private List<Organizer> organizers;

    protected Classroom() {
    }

    public Classroom(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "Class{" +
                "id=" + id +
                '}';
    }
}
