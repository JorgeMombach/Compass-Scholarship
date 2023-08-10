package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "COORDINATOR_TB")
public class Coordinator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CoordinatorId;

    private String name;
}
