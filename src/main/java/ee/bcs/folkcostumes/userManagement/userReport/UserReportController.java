package ee.bcs.folkcostumes.userManagement.userReport;

import ee.bcs.folkcostumes.userManagement.contact.ContactResponse;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupDto;
import ee.bcs.folkcostumes.userManagement.user.UserDto;
import ee.bcs.folkcostumes.userManagement.user.UserRoleInGroupResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/reports")

public class UserReportController {

    @Resource
    private UserReportService userReportService;

    @GetMapping("/get/group/contacts")
    public List<ContactResponse> getContactsInGroup(@RequestParam String groupName) {
        return userReportService.getContactsByGroupName(groupName);
    }

    @GetMapping("/get/group/roles")
    public List<RoleInGroupDto> getRolesInGroupByGroupName (@RequestParam String groupName) {
        return userReportService.getAllUsersRolesInAGroup(groupName);
    }


    @GetMapping("/find/user/by/username")
    public UserDto getUserByUsername(@RequestParam String userName) {
        return userReportService.getUserByUserName(userName);
    }

    @GetMapping("/get/user/roles/in/groups")
    public List<UserRoleInGroupResponse> getRolesInGroupsByUser (@RequestParam String firstName, String lastName) {
        return userReportService.getRolesInAllGroupsByUser(firstName, lastName);
    }
}
