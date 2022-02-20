package ee.bcs.folkcostumes.inventory.elementInCostume;

import lombok.Data;

@Data
public class ElementInCostumeRequest {
    private String elementName;
    private String elementType;
    private String costumeName;
}
