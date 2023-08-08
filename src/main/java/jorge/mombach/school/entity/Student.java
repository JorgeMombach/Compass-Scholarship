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


}
