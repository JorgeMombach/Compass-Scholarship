package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "INSTRUCTOR_TB")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long InstructorId;

}
