package jorge.mombach.school.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CLASS_TB")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long class_id;

    @OneToMany(mappedBy = "class")
    private List<Student> students;

    @OneToMany(mappedBy = "class")
    private List<Organizer> organizers;

    protected Class() {
    }

    public Long getClass_id() {
        return class_id;
    }

    public void setClass_id(Long class_id) {
        this.class_id = class_id;
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
                "class_id=" + class_id +
                '}';
    }
}
