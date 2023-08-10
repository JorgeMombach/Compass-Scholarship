package jorge.mombach.school.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ORGANIZER_TB")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long org_id;
    private String org_name;

    @Enumerated(EnumType.STRING)
    private OrganizerRole org_role;

    @ManyToMany(mappedBy = "organizers")
    private List<Classroom> classrooms;

    public Organizer() {
    }

    public Organizer(Long org_id, String org_name) {
        this.org_id = org_id;
        this.org_name = org_name;
    }

    public Organizer(Long org_id, String org_name, OrganizerRole org_role) {
        this.org_id = org_id;
        this.org_name = org_name;
        this.org_role = org_role;
    }

    public Organizer(Long org_id, String org_name, List<Classroom> classrooms) {
        this.org_id = org_id;
        this.org_name = org_name;
        this.classrooms = classrooms;
    }

    public long getOrg_id() {
        return org_id;
    }

    public void setOrg_id(Long org_id) {
        this.org_id = org_id;
    }

    public String getOrg_name() {
        return org_name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public OrganizerRole getOrg_role() {
        return org_role;
    }

    public void setOrg_role(OrganizerRole org_role) {
        this.org_role = org_role;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "org_id=" + org_id +
                ", org_name='" + org_name + '\'' +
                ", org_role=" + org_role +
                '}';
    }
}
