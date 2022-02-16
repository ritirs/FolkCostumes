package ee.bcs.folkcostumes.userManagement.roleInGroup;

import ee.bcs.folkcostumes.userManagement.group.GroupDto;
import ee.bcs.folkcostumes.userManagement.roleType.RoleTypeDto;
import ee.bcs.folkcostumes.userManagement.user.UserDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoleInGroupDto implements Serializable {
    private final Integer id;
    private final RoleTypeDto roleType;
    private final GroupDto group;
    private final UserDto user;
}
