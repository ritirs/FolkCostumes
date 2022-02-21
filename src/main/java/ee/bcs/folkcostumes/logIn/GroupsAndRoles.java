package ee.bcs.folkcostumes.logIn;

import lombok.Data;

import java.io.Serializable;

@Data
public class GroupsAndRoles implements Serializable {
    private final Integer id;
    private final String roleTypeName;
    private final String groupGroupName;
}
