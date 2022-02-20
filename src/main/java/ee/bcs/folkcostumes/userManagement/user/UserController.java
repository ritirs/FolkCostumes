package ee.bcs.folkcostumes.userManagement.user;

import ee.bcs.folkcostumes.userManagement.contact.ContactResponse;
import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")

public class UserController {

    @Resource
    private ContactService contactService;

    @Resource
    private UserService userService;

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

    @PostMapping("/add/user/with/contacts")
    public String addUserWithContacts(@RequestBody UserContactDataRequest userContactDataRequest) {
        userService.addUserWithContacts(userContactDataRequest);
        return "Uus kasutaja salvestatud.";
    }

    @PostMapping("/update/user/contacts")
    public String updateUserContacts(@RequestBody ContactResponse contactResponse) {
        contactService.updateUserContacts(contactResponse);
        return "Uued andmed salvestatud";
    }
}
