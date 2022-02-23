package ee.bcs.folkcostumes.userManagement;

import ee.bcs.folkcostumes.userManagement.contact.ContactResponse;
import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import ee.bcs.folkcostumes.userManagement.group.GroupDto;
import ee.bcs.folkcostumes.userManagement.group.GroupService;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupRequest;
import ee.bcs.folkcostumes.userManagement.roleType.RoleTypeDto;
import ee.bcs.folkcostumes.userManagement.roleType.RoleTypeService;
import ee.bcs.folkcostumes.userManagement.user.UserContactDataRequest;
import ee.bcs.folkcostumes.userManagement.user.UserRequest;
import ee.bcs.folkcostumes.userManagement.user.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")

public class UserController {

    @Resource
    private ContactService contactService;
    @Resource
    private UserService userService;
    @Resource
    private GroupService groupService;
    @Resource
    private RoleTypeService roleTypeService;

//     TODO: ei pea olema request body? võiks olal eraldi välja? küsimus frondile...
    @PostMapping("/add/new")
    public String addNewUser(@RequestBody UserRequest userRequest) {
        userService.addNewUser(userRequest);
        return "Uus kasutaja salvestatud.";
    }

    @PostMapping("/update/password")
    public String updateUserPassword(@RequestParam String username, @RequestParam String newPassword) {
        return userService.updateUserPassword(username, newPassword);
    }

    @PostMapping("/update/username")
    public String updateUserName(@RequestParam String username, @RequestParam String newUserName) {
        return userService.updateUserName(username, newUserName);
    }

    @PostMapping("/add/with/contacts")
    public String addUserWithContacts(@RequestBody UserContactDataRequest userContactDataRequest) {
        userService.addUserWithContacts(userContactDataRequest);
        return "Uus kasutaja salvestatud.";
    }

    @PostMapping("/update/contacts")
    public String updateUserContacts(@RequestBody ContactResponse contactResponse) {
        contactService.updateUserContacts(contactResponse);
        return "Uued andmed salvestatud";
    }

    @PostMapping("/add/role")
    public String addRoleToUser (@RequestBody RoleInGroupRequest roleInGroupRequest) {
        userService.addRoleToUser(roleInGroupRequest);
        return "Uus roll sisestatud";
    }
    @PostMapping("/group/add/new")
    public GroupDto addNewGroup(@RequestParam String newGroupName) {
        return groupService.addNewGroup(newGroupName);
    }

    @PostMapping("/group/update/name")
    public String updateGroupName(@RequestParam String groupName, @RequestParam String newName) {
        return groupService.updateGroupName(groupName, newName);
    }
    @PostMapping("/role/type/add/new")
    public RoleTypeDto addNewRoleType(@RequestParam String newRoletype) {
        return roleTypeService.addNewRoleType(newRoletype);
    }

    @PostMapping("/role/type//update/name")
    public String updateRoleType(@RequestParam String oldRoleTypeName, @RequestParam String newRoleTypeName) {
        return roleTypeService.updateRoleTypeName(oldRoleTypeName, newRoleTypeName);
    }

}
