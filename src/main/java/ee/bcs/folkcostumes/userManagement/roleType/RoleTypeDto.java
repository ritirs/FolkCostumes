package ee.bcs.folkcostumes.userManagement.roleType;

import lombok.Data;

import java.io.Serializable;

@Data
public class RoleTypeDto implements Serializable {
    private final Integer id;
    private final String name;
}
