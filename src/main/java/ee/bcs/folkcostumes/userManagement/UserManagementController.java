package ee.bcs.folkcostumes.userManagement;

import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserManagementController {

    @Resource
    private ContactService contactService;

    @PostMapping("/add/new")
    public String addNewUser (@RequestBody UserDataRequest userDataRequest) {
        contactService.addNewUser(userDataRequest);
        return "Uus kasutaja lisatud";
    }


}
