package ee.bcs.folkcostumes.userManagement.userReport;

import ee.bcs.folkcostumes.userManagement.contact.ContactResponse;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupDto;
import ee.bcs.folkcostumes.userManagement.user.User;
import ee.bcs.folkcostumes.userManagement.user.UserPassword;
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

    //     TODO: muuda tagastatava info vormingut - mitte DTO vaid lihtsam, ilma id'teta vorm
    @GetMapping("/get/group/roles")
    public List<RoleInGroupDto> getRolesInGroupByGroupName(@RequestParam String groupName) {
        return userReportService.getAllUsersRolesInAGroup(groupName);
    }

    @GetMapping("/get/user/contact")
    public ContactResponse getUserContact(@RequestParam String firstname, @RequestParam String lastname) {
        return userReportService.getUserContact(firstname, lastname);
    }

    //    TODO: kontrolli, kas on turva peal, et ei saa panna sama inimest kaks korda samasse rolli
    @GetMapping("/get/user/roles/in/groups")
    public List<UserRoleInGroupResponse> getRolesInGroupsByUser(@RequestParam String firstname, @RequestParam String lastname) {
        return userReportService.getRolesInAllGroupsByUser(firstname, lastname);
    }

    //    TODO: ei anna nimesid tagasi, tuleb settida
    //  admin funktsioon
    @GetMapping("/get/user/username/and/password/by/names")
    public UserPassword getUserPassword(@RequestParam String firstname, @RequestParam String lastname) {
        return userReportService.getUserPassword(firstname, lastname);
    }

    //    admin funktsioon
    @GetMapping("/get/all/users/and/passwords/by/group")
    public List<UserPassword> getAllUsersPasswordsByGroup(String groupName) {
        return userReportService.getAllUserPasswordsByGroup(groupName);
    }

    //    admin funktsioon
    @GetMapping("/get/all/group/names")
    public List<String> allGroupNames() {
        return userReportService.getAllGroupNames();
    }

    //    admin funktsioon
    @GetMapping("/get/all/role/type/names")
    public List<String> allRoleTypeNames() {
        return userReportService.getAllRoleTypeNames();
    }

    @GetMapping("/get/all/users/first/last/name")
    public List<FirstLastNames> getAllUsersNames() {
        return userReportService.getAllUsersNames();
    }

    @GetMapping("/get/user/by/names")
    public String getUserByNames(FirstLastNames names) {
        return userReportService.getUserByNames(names.getFirstname(), names.getLastname());
    }
}
