package ee.bcs.folkcostumes.roleInGroup;

import ee.bcs.folkcostumes.group.GroupDto;
import ee.bcs.folkcostumes.roleType.RoleTypeDto;
import ee.bcs.folkcostumes.user.UserDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoleInGroupDto implements Serializable {
    private final Integer id;
    private final RoleTypeDto roleType;
    private final GroupDto group;
    private final UserDto user;
}
