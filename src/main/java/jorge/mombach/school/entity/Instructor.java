package jorge.mombach.school.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "INSTRUCTOR_TB")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inst_id;
    private String inst_name;

    public Instructor() {
    }

    public Instructor(Long inst_id, String inst_name) {
        this.inst_id = inst_id;
        this.inst_name = inst_name;
    }

    public Long getInst_id() {
        return inst_id;
    }

    public void setInst_id(Long inst_id) {
        this.inst_id = inst_id;
    }

    public String getInst_name() {
        return inst_name;
    }

    public void setInst_name(String inst_name) {
        this.inst_name = inst_name;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "inst_id=" + inst_id +
                ", inst_name='" + inst_name + '\'' +
                '}';
    }
}
