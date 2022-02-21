package ee.bcs.folkcostumes.logIn;

import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroup;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupDto;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupService;
import ee.bcs.folkcostumes.userManagement.user.User;
import ee.bcs.folkcostumes.userManagement.user.UserService;
import ee.bcs.folkcostumes.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private GroupsAndRolesMapper groupsAndRolesMapper;

    public LoginResponse login(String userName, String password) {

        User user = userService.getValidUserName(userName);
        validationService.userExists(Optional.ofNullable(user), userName);
        validationService.passwordIsCorrect(user, password);

        Integer userId = user.getId();
        String firstname = contactService.getFirstNameById(userId);
        String lastname = contactService.getLastNameById(userId);
        List<RoleInGroup> userRolesInGroups = roleInGroupService.rolesInGroupsByUserId(userId);
        List<GroupsAndRoles> loginRolesList = new ArrayList<>();
        for (RoleInGroup rolesInGroup : userRolesInGroups) {
            loginRolesList.add(groupsAndRolesMapper.roleInGroupToGroupsAndRoles(rolesInGroup));
        }
//        LoginResponse loginResponse = new LoginResponse(userId, firstname, lastname, loginRolesList);
        return new LoginResponse(userId, firstname, lastname, loginRolesList);
    }
}
