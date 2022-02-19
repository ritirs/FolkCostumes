package ee.bcs.folkcostumes.userManagement.user;

import lombok.Data;

@Data
public class UserRoleInGroupResponse {
    private String firstName;
    private String lastName;
    private String groupName;
    private String roleName;
    private String telephone;

    public UserRoleInGroupResponse() {
    }

    public UserRoleInGroupResponse(String firstName, String lastName, String groupName, String roleName, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupName = groupName;
        this.roleName = roleName;
        this.telephone = telephone;
    }
}

