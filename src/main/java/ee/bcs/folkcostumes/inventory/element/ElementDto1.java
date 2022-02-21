package ee.bcs.folkcostumes.inventory.element;

import lombok.Data;

import java.io.Serializable;

@Data
public class ElementDto1 implements Serializable {
    private final Integer id;
    private final Integer elementTypeId;
    private final String elementTypeElementType;
    private final String elementName;
    private final String description;
}
