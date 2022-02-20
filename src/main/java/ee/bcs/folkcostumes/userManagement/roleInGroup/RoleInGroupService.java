package ee.bcs.folkcostumes.userManagement.roleInGroup;

import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import ee.bcs.folkcostumes.userManagement.group.Group;
import ee.bcs.folkcostumes.userManagement.group.GroupService;
import ee.bcs.folkcostumes.userManagement.roleType.RoleType;
import ee.bcs.folkcostumes.userManagement.roleType.RoleTypeService;
import ee.bcs.folkcostumes.userManagement.user.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleInGroupService {

    @Resource
    private RoleInGroupMapper roleInGroupMapper;

    @Resource
    private RoleInGroupRepository roleInGroupRepository;

    public List<RoleInGroupDto> rolesInGroups(Integer userId) {
        List<RoleInGroup> rolesInGroup = roleInGroupRepository.findUserRolesInGroupsByUser_Id(userId);
        return roleInGroupMapper.roleInGroupToRoleInGroupDtos(rolesInGroup);
    }

    public List<RoleInGroupDto> usersAndRolesInGroup(String groupName) {
        List<RoleInGroup> usersRolesInGroup = roleInGroupRepository.findByGroup_GroupName(groupName);
        return roleInGroupMapper.roleInGroupToRoleInGroupDtos(usersRolesInGroup);
    }

    public boolean isUserInGroup(Integer userId, String groupName) {
        return roleInGroupRepository.existsByGroup_GroupNameAndUser_Id(groupName, userId);
    }

}
