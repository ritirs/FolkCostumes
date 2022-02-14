package ee.bcs.folkcostumes.transactions;

import ee.bcs.folkcostumes.costume.ElementInCostume;

import javax.persistence.*;

@Entity
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "element_in_costume_id")
    private ElementInCostume elementInCostume;

    public ElementInCostume getElementInCostume() {
        return elementInCostume;
    }

    public void setElementInCostume(ElementInCostume elementInCostume) {
        this.elementInCostume = elementInCostume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //TODO Reverse Engineering! Migrate other columns to the entity
}