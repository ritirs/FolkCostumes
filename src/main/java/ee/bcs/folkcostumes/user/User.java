package ee.bcs.folkcostumes.user;

import ee.bcs.folkcostumes.inventoryLog.LocationBalance;
import ee.bcs.folkcostumes.inventoryLog.LocationLog;

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

    @Lob
    @Column(name = "username", nullable = false)
    private String username;

    @OneToMany(mappedBy = "user")
    private Set<Contact> contacts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<LocationLog> locationLogs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<RoleInGroup> roleInGroups = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<LocationBalance> locationBalances = new LinkedHashSet<>();

    public Set<LocationBalance> getLocationBalances() {
        return locationBalances;
    }

    public void setLocationBalances(Set<LocationBalance> locationBalances) {
        this.locationBalances = locationBalances;
    }

    public Set<RoleInGroup> getRoleInGroups() {
        return roleInGroups;
    }

    public void setRoleInGroups(Set<RoleInGroup> roleInGroups) {
        this.roleInGroups = roleInGroups;
    }

    public Set<LocationLog> getLocationLogs() {
        return locationLogs;
    }

    public void setLocationLogs(Set<LocationLog> locationLogs) {
        this.locationLogs = locationLogs;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}