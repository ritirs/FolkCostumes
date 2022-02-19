package ee.bcs.folkcostumes.userManagement.user;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserContactDataRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String telephone;
    private LocalDate birthDate;
    private String address;
    private String userName;
    private String password;
}
