package ee.bcs.folkcostumes.userManagement.user;

import ee.bcs.folkcostumes.userManagement.contact.ContactDto;
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
    public String updateUserPassword(@RequestParam String userName, @RequestParam String newPassword) {
        return userService.updateUserPassword(userName, newPassword);
    }

    @PostMapping("/update/username")
    public String updateUserName(@RequestParam String userName, @RequestParam String newUserName) {
        return userService.updateUserName(userName, newUserName);
    }

    @PostMapping("/add/user/with/contacts")
    public String addUserWithContacts(@RequestBody UserContactDataRequest userContactDataRequest) {
        userService.addUserWithContacts(userContactDataRequest);
        return "Uus kasutaja salvestatud.";
    }

    @GetMapping("/find/by/name")
    public UserDto findUserByNames(@RequestParam String firstName, @RequestParam String lastName) {
        ContactDto contactDto = contactService.getContactDtoByName(firstName, lastName);
        return contactDto.getUser();
    }

//    @GetMapping("/find/user/by/username")
//    public UserDto findUserByUsername(@RequestParam String userName) {
//        return userService.getUserByUserName(userName);
//    }
}
