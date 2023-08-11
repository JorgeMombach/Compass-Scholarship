package jorge.mombach.school.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "INSTRUCTOR_TB")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long InstructorId;

    private String name;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Instructor() {
    }

    public Instructor(Long instructorId, String name) {
        InstructorId = instructorId;
        this.name = name;
    }

    public Instructor(Long instructorId, String name, Classroom classroom) {
        InstructorId = instructorId;
        this.name = name;
        this.classroom = classroom;
    }

    public Long getInstructorId() {
        return InstructorId;
    }

    public void setInstructorId(Long instructorId) {
        InstructorId = instructorId;
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
        return "Instructor{" +
                "InstructorId=" + InstructorId +
                ", name='" + name + '\'' +
                '}';
    }
}
