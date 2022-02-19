package ee.bcs.folkcostumes.userManagement.userReport;

import ee.bcs.folkcostumes.userManagement.contact.ContactResponse;
import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import ee.bcs.folkcostumes.userManagement.group.GroupService;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupDto;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupService;
import ee.bcs.folkcostumes.userManagement.user.User;
import ee.bcs.folkcostumes.userManagement.user.UserDto;
import ee.bcs.folkcostumes.userManagement.user.UserRoleInGroupResponse;
import ee.bcs.folkcostumes.userManagement.user.UserService;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    public List<ContactResponse> getContactsByGroupName(String groupName) {
        List<ContactResponse> allContacts = contactService.getAllContacts();
        List<ContactResponse> contactsOfGroup = new ArrayList<>();
        for (ContactResponse contactResponse : allContacts) {
            User user = userService.getUserByNames(contactResponse.getFirstname(), contactResponse.getLastname());
            if (roleInGroupService.isUserInGroup(user.getId(), groupName)) {
                contactsOfGroup.add(contactResponse);
            }
        }
        return contactsOfGroup;
    }

    public UserDto getUserByUserName(String userName) {
        return userService.getUserDtoByUserName(userName);
    }



    public List<RoleInGroupDto> getAllUsersRolesInAGroup(String groupName) {
        return userService.getUserRolesByGroup(groupName);
    }

    public List<UserRoleInGroupResponse> getRolesInAllGroupsByUser(String firstName, String lastName) {
        User user = userService.getUserByNames(firstName, lastName);
        return userService.getRolesInAllGroupsByUser(user.getId());
    }
}
