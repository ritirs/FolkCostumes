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
    public ContactDto addNewUser(@RequestBody UserDataRequest userDataRequest) {
        String username = userDataRequest.getUsername();
        User newUser = userService.addNewUser(username);
        return contactService.addNewContact(userDataRequest, newUser);
    }

    public Integer findUserByName(@RequestParam String firstName, @RequestParam String lastName) {
        Integer userId = contactService.getUserIdByName(firstName, lastName);
        return userId;
    }

}
