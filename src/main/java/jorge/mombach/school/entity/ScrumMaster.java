package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SCRUMMASTER_TB")
public class ScrumMaster {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ScrumMasterId;
}
