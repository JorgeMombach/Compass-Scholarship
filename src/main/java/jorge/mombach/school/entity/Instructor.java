package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "INSTRUCTOR_TB")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructor_id;

    private String instructor_name;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Instructor() {
    }

    public Instructor(Long instructor_id, String instructor_name) {
        this.instructor_id = instructor_id;
        this.instructor_name = instructor_name;
    }

    public Instructor(Long instructor_id, String instructor_name, Classroom classroom) {
        this.instructor_id = instructor_id;
        this.instructor_name = instructor_name;
        this.classroom = classroom;
    }

    public Long getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(Long instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "instructor_id=" + instructor_id +
                ", instructor_name='" + instructor_name + '\'' +
                '}';
    }
}
