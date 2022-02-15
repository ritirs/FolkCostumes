package ee.bcs.folkcostumes.elementType;

import lombok.Data;

import java.io.Serializable;

@Data
public class ElementTypeDto implements Serializable {
    private final Integer id;
    private final String elementType;
}
