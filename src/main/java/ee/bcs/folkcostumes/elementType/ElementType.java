package ee.bcs.folkcostumes.elementType;

import javax.persistence.*;

@Entity
@Table(name = "element_type")
public class ElementType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "element_type", nullable = false, length = 50)
    private String elementType;

    public String getElementType() {
        return elementType;
    }

    public void setElementType(String elementType) {
        this.elementType = elementType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}