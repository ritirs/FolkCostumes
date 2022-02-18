package ee.bcs.folkcostumes.userManagement.userReport;

import ee.bcs.folkcostumes.userManagement.contact.Contact;
import ee.bcs.folkcostumes.userManagement.contact.ContactResponse;
import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import ee.bcs.folkcostumes.userManagement.group.Group;
import ee.bcs.folkcostumes.userManagement.group.GroupService;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroup;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupService;
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
            if (roleInGroupService.isUserInGroup(contactResponse.getUserId(), groupName)) {
                contactsOfGroup.add(contactResponse);
            }
        }
            return contactsOfGroup;
    }

    }
