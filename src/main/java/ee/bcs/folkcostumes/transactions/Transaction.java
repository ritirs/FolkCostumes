package ee.bcs.folkcostumes.transactions;

import ee.bcs.folkcostumes.costume.ElementInCostume;
import ee.bcs.folkcostumes.user.User;

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

    @Entity
    @Table(name = "status")
    public static class Status {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id", nullable = false)
        private Integer id;
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User user;

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        //TODO Reverse Engineering! Migrate other columns to the entity
    }
}