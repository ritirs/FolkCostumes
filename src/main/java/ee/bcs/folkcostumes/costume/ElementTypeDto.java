package ee.bcs.folkcostumes.costume;

import lombok.Data;

import java.io.Serializable;

@Data
public class ElementTypeDto implements Serializable {
    private final Integer id;
    private final String elementType;
}
