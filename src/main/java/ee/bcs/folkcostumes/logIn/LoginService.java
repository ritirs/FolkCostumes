package ee.bcs.folkcostumes.logIn;

import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroup;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupDto;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupService;
import ee.bcs.folkcostumes.userManagement.user.User;
import ee.bcs.folkcostumes.userManagement.user.UserDto;
import ee.bcs.folkcostumes.userManagement.user.UserMapper;
import ee.bcs.folkcostumes.userManagement.user.UserService;
import ee.bcs.folkcostumes.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Resource
    private ContactService contactService;

    @Resource
    private UserService userService;

    @Resource
    ValidationService validationService;

    @Resource
    RoleInGroupService roleInGroupService;

    public LoginResponse login(String userName, String password) {

        User user = userService.getUserByUserName(userName);
        validationService.userExists(Optional.ofNullable(user), userName);
        validationService.passwordIsCorrect(user, password);

        Integer userId = user.getId();
        String firstName = contactService.getFirstNameById(userId);
        String lastName = contactService.getLastNameById(userId);
        List<RoleInGroupDto> rolesInGroup = roleInGroupService.rolesInGroups(userId);

        LoginResponse response;
        response = new LoginResponse(userId, firstName, lastName, rolesInGroup);
        return response;
    }
}
