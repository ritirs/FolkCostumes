package ee.bcs.folkcostumes.costume;

import ee.bcs.folkcostumes.transactions.InventoryBalance;
import ee.bcs.folkcostumes.transactions.Transaction;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "element_in_costume")
public class ElementInCostume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "costume_id", nullable = false)
    private Costume costume;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "set_element_id", nullable = false)
    private Element element;

    @OneToMany(mappedBy = "elementInCostume")
    private Set<InventoryBalance> inventoryBalances = new LinkedHashSet<>();

    @OneToMany(mappedBy = "elementInCostume")
    private Set<Transaction> transactions = new LinkedHashSet<>();

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Set<InventoryBalance> getInventoryBalances() {
        return inventoryBalances;
    }

    public void setInventoryBalances(Set<InventoryBalance> inventoryBalances) {
        this.inventoryBalances = inventoryBalances;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Costume getCostume() {
        return costume;
    }

    public void setCostume(Costume costume) {
        this.costume = costume;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}