package ee.bcs.folkcostumes.costume;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "costume")
public class Costume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "costume")
    private Set<ElementInCostume> elementInCostumes = new LinkedHashSet<>();

    public Set<ElementInCostume> getElementInCostumes() {
        return elementInCostumes;
    }

    public void setElementInCostumes(Set<ElementInCostume> elementInCostumes) {
        this.elementInCostumes = elementInCostumes;
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