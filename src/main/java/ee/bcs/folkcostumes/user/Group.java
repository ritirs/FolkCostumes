package ee.bcs.folkcostumes.user;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"group\"")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "group_name", nullable = false, length = 50)
    private String groupName;

    @OneToMany(mappedBy = "group")
    private Set<RoleInGroup> roleInGroups = new LinkedHashSet<>();

    public Set<RoleInGroup> getRoleInGroups() {
        return roleInGroups;
    }

    public void setRoleInGroups(Set<RoleInGroup> roleInGroups) {
        this.roleInGroups = roleInGroups;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}