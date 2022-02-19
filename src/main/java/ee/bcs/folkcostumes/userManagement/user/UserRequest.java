package ee.bcs.folkcostumes.userManagement.user;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
}
