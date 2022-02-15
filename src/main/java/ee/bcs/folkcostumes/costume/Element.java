package ee.bcs.folkcostumes.costume;

import ee.bcs.folkcostumes.inventoryLog.LocationBalance;
import ee.bcs.folkcostumes.inventoryLog.LocationLog;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "element")
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "element_type_id", nullable = false)
    private ElementType elementType;

    @Column(name = "element_name", nullable = false, length = 50)
    private String elementName;

    @Column(name = "description", nullable = false, length = 250)
    private String description;

    @OneToMany(mappedBy = "element")
    private Set<LocationLog> locationLogs = new LinkedHashSet<>();

    @OneToMany(mappedBy = "element")
    private Set<ElementInCostume> elementInCostumes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "element")
    private Set<LocationBalance> locationBalances = new LinkedHashSet<>();

    public Set<LocationBalance> getLocationBalances() {
        return locationBalances;
    }

    public void setLocationBalances(Set<LocationBalance> locationBalances) {
        this.locationBalances = locationBalances;
    }

    public Set<ElementInCostume> getElementInCostumes() {
        return elementInCostumes;
    }

    public void setElementInCostumes(Set<ElementInCostume> elementInCostumes) {
        this.elementInCostumes = elementInCostumes;
    }

    public Set<LocationLog> getLocationLogs() {
        return locationLogs;
    }

    public void setLocationLogs(Set<LocationLog> locationLogs) {
        this.locationLogs = locationLogs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public ElementType getElementType() {
        return elementType;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}