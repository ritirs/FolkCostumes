package ee.bcs.folkcostumes.inventoryLog;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "location", nullable = false, length = 50)
    private String location;

    @OneToMany(mappedBy = "location")
    private Set<LocationLog> locationLogs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "location")
    private Set<LocationBalance> locationBalances = new LinkedHashSet<>();

    public Set<LocationBalance> getLocationBalances() {
        return locationBalances;
    }

    public void setLocationBalances(Set<LocationBalance> locationBalances) {
        this.locationBalances = locationBalances;
    }

    public Set<LocationLog> getLocationLogs() {
        return locationLogs;
    }

    public void setLocationLogs(Set<LocationLog> locationLogs) {
        this.locationLogs = locationLogs;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}