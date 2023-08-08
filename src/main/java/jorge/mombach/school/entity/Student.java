package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENT_TB")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long student_id;

    private String student_fname;
    private String student_lname;

    public Student() {
    }

    public Student(long student_id, String student_fname, String student_lname) {
        this.student_id = student_id;
        this.student_fname = student_fname;
        this.student_lname = student_lname;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
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

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_fname='" + student_fname + '\'' +
                ", student_lname='" + student_lname + '\'' +
                '}';
    }
}
