package ee.bcs.folkcostumes.userManagement.user;

import lombok.Data;

@Data
public class UserRoleInGroupResponse {
    private String firstname;
    private String lastname;
    private String groupName;
    private String roleName;
    private String telephone;

//    public UserRoleInGroupResponse() {
//    }
//
//    public UserRoleInGroupResponse(String firstname, String lastname, String groupName, String roleName, String telephone) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.groupName = groupName;
//        this.roleName = roleName;
//        this.telephone = telephone;
//    }
}

