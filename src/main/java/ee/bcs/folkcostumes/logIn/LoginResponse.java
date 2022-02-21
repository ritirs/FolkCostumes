package ee.bcs.folkcostumes.logIn;

import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private final Integer userId;
    private final String firstname;
    private final String lastname;
    private final List<GroupsAndRoles> groupAndRoleList;
}
//public class LoginResponse {
//    private final Integer userId;
//    private final String firstname;
//    private final String lastname;
//    private final List<RoleInGroupDto> roleId;
//}
