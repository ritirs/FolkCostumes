package ee.bcs.folkcostumes.userManagement;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class UserDataRequest implements Serializable {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String telephone;
    private final LocalDate birthDate;
    private final String address;
    private final String username;

}
