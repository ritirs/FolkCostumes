package ee.bcs.folkcostumes.locationManagement.TransactionLog;

import ee.bcs.folkcostumes.inventory.element.Element;
import ee.bcs.folkcostumes.locationManagement.location.Location;
import ee.bcs.folkcostumes.userManagement.user.User;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "location_log")
public class TransactionLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "element_id", nullable = false)
    private Element element;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    private Location location;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "balance", nullable = false)
    private Integer balance;

    @Column(name = "transaction_time", nullable = false)
    private LocalDate transactionTime;

    public LocalDate getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDate transactionTime) {
        this.transactionTime = transactionTime;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Element getElement() {
        return element;
    }

    public void setElement(Element element) {
        this.element = element;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}