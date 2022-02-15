package ee.bcs.folkcostumes.elementInCostume;

import ee.bcs.folkcostumes.costume.CostumeDto;
import ee.bcs.folkcostumes.element.ElementDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class ElementInCostumeDto implements Serializable {
    private final Integer id;
    private final CostumeDto costume;
    private final ElementDto element;
}
