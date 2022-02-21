package ee.bcs.folkcostumes.inventory.elementInCostume;

import lombok.Data;

import java.io.Serializable;

@Data
public class ElementInCostumeDtoLarge implements Serializable {
    private final Integer id;
    private final Integer costumeId;
    private final String costumeName;
    private final Integer elementId;
    private final Integer elementElementTypeId;
    private final String elementElementTypeElementType;
    private final String elementElementName;
    private final String elementDescription;
}
