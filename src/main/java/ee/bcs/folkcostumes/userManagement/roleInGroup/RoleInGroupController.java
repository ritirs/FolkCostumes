package ee.bcs.folkcostumes.userManagement.roleInGroup;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/role/in/group")
public class RoleInGroupController {

    @Resource
    private RoleInGroupService roleInGroupService;

    @PostMapping("/add/new")
    public RoleInGroupDto addNewRoleToUser(@RequestBody RoleInGroupRequest request) {
        return roleInGroupService.addNewRoleToUser(request);
    }

}
