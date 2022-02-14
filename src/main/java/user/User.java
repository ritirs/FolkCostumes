package user;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "firstname", nullable = false)
    private Integer firstname;

    @Column(name = "lastname", nullable = false)
    private Integer lastname;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    @OneToMany(mappedBy = "user")
    private Set<UserInGroup> userInGroups = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Status> statuses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles = new LinkedHashSet<>();

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Set<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<Status> statuses) {
        this.statuses = statuses;
    }

    public Set<UserInGroup> getUserInGroups() {
        return userInGroups;
    }

    public void setUserInGroups(Set<UserInGroup> userInGroups) {
        this.userInGroups = userInGroups;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Integer getLastname() {
        return lastname;
    }

    public void setLastname(Integer lastname) {
        this.lastname = lastname;
    }

    public Integer getFirstname() {
        return firstname;
    }

    public void setFirstname(Integer firstname) {
        this.firstname = firstname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}