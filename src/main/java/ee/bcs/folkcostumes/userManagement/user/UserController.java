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
        UserDto newUser = userService.addNewUser(userDataRequest);
        return contactService.addNewContact(userDataRequest, newUser);
    }

    @PostMapping("/find/by/name")
    public UserDto findUserByName(@RequestParam String firstName, @RequestParam String lastName) {
        ContactDto contactDto = contactService.getContactDtoByName(firstName, lastName);
        return contactDto.getUser();
    }

}
