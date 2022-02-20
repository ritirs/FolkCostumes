package ee.bcs.folkcostumes.inventory.elementType;

import lombok.Data;

import java.io.Serializable;

@Data
public class ElementTypeDto implements Serializable {
    private final Integer userId;
    private final Integer roleId;
    private final String elementType;
}
