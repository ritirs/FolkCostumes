package ee.bcs.folkcostumes.roleType;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleTypeDto implements Serializable {
    private final Integer id;
    private final String name;
}
