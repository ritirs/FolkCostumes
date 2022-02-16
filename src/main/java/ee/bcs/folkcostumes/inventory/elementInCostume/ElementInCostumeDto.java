package ee.bcs.folkcostumes.inventory.elementInCostume;

import ee.bcs.folkcostumes.inventory.costume.CostumeDto;
import ee.bcs.folkcostumes.inventory.element.ElementDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class ElementInCostumeDto implements Serializable {
    private final Integer id;
    private final CostumeDto costume;
    private final ElementDto element;
}
