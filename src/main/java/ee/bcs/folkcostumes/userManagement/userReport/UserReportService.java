package ee.bcs.folkcostumes.userManagement.userReport;

import ee.bcs.folkcostumes.userManagement.contact.ContactResponse;
import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import ee.bcs.folkcostumes.userManagement.group.GroupService;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupDto;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupService;
import ee.bcs.folkcostumes.userManagement.roleType.RoleTypeService;
import ee.bcs.folkcostumes.userManagement.user.*;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class UserReportService {

    @Resource
    private UserService userService;

    @Resource
    private RoleInGroupService roleInGroupService;

    @Resource
    private GroupService groupService;

    @Resource
    private ContactService contactService;

    @Resource
    private RoleTypeService roleTypeService;

    public UserPassword getUserPassword(String firstname, String lastname) {
        User user = contactService.getUserByNames(firstname, lastname);
        return userService.getUserPassword(user);
    }

    public List<ContactResponse> getContactsByGroupName(String groupName) {
        return userService.getContactsByGroupName(groupName);
    }

    public User getUserByNames(String firstName, String lastName) {
        return contactService.getUserByNames(firstName, lastName);
    }

    public List<RoleInGroupDto> getAllUsersRolesInAGroup(String groupName) {
        return roleInGroupService.usersAndRolesInGroup(groupName);
    }

    public List<UserRoleInGroupResponse> getRolesInAllGroupsByUser(String firstname, String lastname) {
        User user = contactService.getUserByNames(firstname, lastname);
        return userService.getRolesInAllGroupsByUser(user.getId());
    }

    public ContactResponse getUserContact(String firstname, String lastname) {
        User user = contactService.getUserByNames(firstname, lastname);
        return userService.getUserContact(user);

    }

    public List<UserPassword> getAllUserPasswordsByGroup(String groupName) {
        return userService.getUsersPasswordsByGroup(groupName);
    }

    public List<String> getAllGroupNames() {
        return groupService.getAllGroupNames();
    }

    public List<String> getAllRoleTypeNames() {
        return roleTypeService.getAllRoleTypeNames();
    }
}
