package ee.bcs.folkcostumes.userManagement.roleInGroup;

import ee.bcs.folkcostumes.userManagement.group.GroupDto;
import ee.bcs.folkcostumes.userManagement.roleType.RoleTypeDto;
import lombok.Data;

@Data
public class RoleInGroupRequest {
    private String firstname;
    private String lastname;
    private String roleType;
    private String group;
}
