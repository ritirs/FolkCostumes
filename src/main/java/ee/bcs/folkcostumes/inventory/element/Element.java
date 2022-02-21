package ee.bcs.folkcostumes.inventory.element;

import ee.bcs.folkcostumes.inventory.elementType.ElementType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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

}