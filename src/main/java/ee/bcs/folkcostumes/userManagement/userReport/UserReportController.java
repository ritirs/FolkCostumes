package ee.bcs.folkcostumes.userManagement.userReport;

import ee.bcs.folkcostumes.userManagement.contact.ContactResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/reports")

public class UserReportController {

    @Resource
    private UserReportService userReportService;

    @GetMapping("/get/group/contacts")
    public List<ContactResponse> getContactsInGroup(String groupname) {
        return userReportService.getContactsByGroupName(groupname);
    }

}
