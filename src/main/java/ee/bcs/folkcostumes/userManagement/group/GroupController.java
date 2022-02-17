package ee.bcs.folkcostumes.userManagement.group;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Resource
    private GroupService groupService;

    @PutMapping("/add/new")
    public GroupDto addNewGroup(@RequestParam String newGroupName) {
        return groupService.addNewGroup(newGroupName);
    }

    @PostMapping("/update/group/name")
    public String updateGroupName(@RequestParam String groupName, @RequestParam String newName) {
        return groupService.updateGroup(groupName, newName);
    }

    @GetMapping("/get/all/group/names")
    public List<String> allGroupNames() {
        return groupService.getAllGroupNames();
    }

}
