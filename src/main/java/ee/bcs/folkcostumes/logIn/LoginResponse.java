package ee.bcs.folkcostumes.logIn;

import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private final Integer userId;
    private final String firstName;
    private final String lastName;
    private final List<Integer> roleId;
}
