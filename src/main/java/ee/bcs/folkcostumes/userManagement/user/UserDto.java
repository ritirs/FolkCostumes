package ee.bcs.folkcostumes.userManagement.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDto implements Serializable {
    private final Integer id;
    private final String username;
}
