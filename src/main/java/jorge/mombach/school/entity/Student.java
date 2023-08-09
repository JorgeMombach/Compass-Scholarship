package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENT_TB")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    private String student_name;

    @ManyToOne
    @JoinColumn(name="classroom_id")
    private Classroom classroom;

    @ManyToOne
    @JoinColumn(name="squad_id")
    private Squad squad;

    public Student() {
    }

    public Student(Long student_id, String student_name) {
        this.student_id = student_id;
        this.student_name = student_name;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                '}';
    }
}
