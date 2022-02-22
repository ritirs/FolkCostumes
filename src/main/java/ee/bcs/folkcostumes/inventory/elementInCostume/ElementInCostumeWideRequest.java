package ee.bcs.folkcostumes.inventory.elementInCostume;

import lombok.Data;

import java.io.Serializable;

@Data
public class ElementInCostumeWideRequest implements Serializable {
    private final String costumeName;
    private final String elementTypeName;
    private final String elementName;
    private final String elementDescription;
}
