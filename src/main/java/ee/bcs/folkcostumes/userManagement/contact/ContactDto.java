package ee.bcs.folkcostumes.userManagement.contact;

import ee.bcs.folkcostumes.userManagement.user.UserDto;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ContactDto implements Serializable {
    private final Integer id;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String telephone;
    private final LocalDate birthDate;
    private final String address;
    private final UserDto user;
}
