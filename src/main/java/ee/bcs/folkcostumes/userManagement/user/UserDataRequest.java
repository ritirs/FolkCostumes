package ee.bcs.folkcostumes.userManagement.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDataRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;
    private LocalDate birthDate;
    private String address;
    private String username;

}
