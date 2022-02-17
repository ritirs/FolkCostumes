package ee.bcs.folkcostumes.inventory.element;

import ee.bcs.folkcostumes.inventory.elementType.ElementTypeRequest;
import lombok.Data;

import java.io.Serializable;

@Data
public class ElementDto implements Serializable {
    private final Integer id;
    private final ElementTypeRequest elementType;
    private final String elementName;
    private final String description;
}
