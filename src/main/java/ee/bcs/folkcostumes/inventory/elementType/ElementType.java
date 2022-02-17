package ee.bcs.folkcostumes.inventory.elementType;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "element_type")
public class ElementType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "element_type", nullable = false, length = 50)
    private String elementType;

 }