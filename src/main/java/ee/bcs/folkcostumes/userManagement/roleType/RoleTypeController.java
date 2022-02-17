package ee.bcs.folkcostumes.userManagement.roleType;


import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/roleType")
public class RoleTypeController {

    @Resource
    private RoleTypeService roleTypeService;

    @PutMapping("/add/new")
    public RoleTypeDto addNewRoleType(@RequestParam String newRoletype) {
        return roleTypeService.addNewRoleType(newRoletype);
    }

    @PostMapping("/update/role/type/name")
    public String updateRoleType(@RequestParam String oldRoleTypeName, @RequestParam String newRoleTypeName) {
        return roleTypeService.updateRoleTypeName(oldRoleTypeName, newRoleTypeName);
    }

    @GetMapping("/get/all/role/type/names")
    public List<String> allRoleTypeNames() {
        return roleTypeService.getAllRoleTypeNames();
    }


}
