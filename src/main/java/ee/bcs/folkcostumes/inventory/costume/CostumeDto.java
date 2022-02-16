package ee.bcs.folkcostumes.inventory.costume;

import lombok.Data;

import java.io.Serializable;

@Data
public class CostumeDto implements Serializable {
    private final Integer id;
    private final String name;
}
