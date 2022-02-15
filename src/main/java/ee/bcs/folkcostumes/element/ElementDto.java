package ee.bcs.folkcostumes.element;

import ee.bcs.folkcostumes.elementType.ElementTypeDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class ElementDto implements Serializable {
    private final Integer id;
    private final ElementTypeDto elementType;
    private final String elementName;
    private final String description;
}
