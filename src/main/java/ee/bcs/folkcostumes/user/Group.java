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

    @Column(name = "group_name", nullable = false)
    private Integer groupName;

    @OneToMany(mappedBy = "group")
    private Set<UserInGroup> userInGroups = new LinkedHashSet<>();

    public Set<UserInGroup> getUserInGroups() {
        return userInGroups;
    }

    public void setUserInGroups(Set<UserInGroup> userInGroups) {
        this.userInGroups = userInGroups;
    }

    public Integer getGroupName() {
        return groupName;
    }

    public void setGroupName(Integer groupName) {
        this.groupName = groupName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}