package ee.bcs.folkcostumes.inventory.elementInCostume;

import lombok.Data;

import java.io.Serializable;

@Data
public class ElementInCostumeWideRequest implements Serializable {
    private final String costumeName;
    private final String elementElementTypeElementType;
    private final String elementElementName;
    private final String elementDescription;
}
