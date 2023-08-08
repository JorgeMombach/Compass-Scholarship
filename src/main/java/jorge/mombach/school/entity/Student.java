package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENT_TB")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;
    private String student_fname;
    private String student_lname;

    @ManyToOne
    @JoinColumn(name="class_id")
    private Class class_id;

    public Student() {
    }

    public Student(Long student_id, String student_fname, String student_lname) {
        this.student_id = student_id;
        this.student_fname = student_fname;
        this.student_lname = student_lname;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_fname() {
        return student_fname;
    }

    public void setStudent_fname(String student_fname) {
        this.student_fname = student_fname;
    }

    public String getStudent_lname() {
        return student_lname;
    }

    public void setStudent_lname(String student_lname) {
        this.student_lname = student_lname;
    }

    public Class getClass_id() {
        return class_id;
    }

    public void setClass_id(Class class_id) {
        this.class_id = class_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_fname='" + student_fname + '\'' +
                ", student_lname='" + student_lname + '\'' +
                '}';
    }
}
