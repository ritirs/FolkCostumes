package ee.bcs.folkcostumes.user;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "role_type")
public class RoleType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "roleType")
    private Set<RoleInGroup> roleInGroups = new LinkedHashSet<>();

    public Set<RoleInGroup> getRoleInGroups() {
        return roleInGroups;
    }

    public void setRoleInGroups(Set<RoleInGroup> roleInGroups) {
        this.roleInGroups = roleInGroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}