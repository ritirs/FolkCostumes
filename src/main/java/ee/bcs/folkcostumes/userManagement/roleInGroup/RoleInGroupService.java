package ee.bcs.folkcostumes.userManagement.roleInGroup;

import ee.bcs.folkcostumes.userManagement.group.Group;
import ee.bcs.folkcostumes.userManagement.roleType.RoleType;
import ee.bcs.folkcostumes.userManagement.user.User;
import ee.bcs.folkcostumes.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleInGroupService {

    @Resource
    private RoleInGroupMapper roleInGroupMapper;

    @Resource
    private RoleInGroupRepository roleInGroupRepository;

    @Resource
    private ValidationService validationService;

    public List<RoleInGroupDto> rolesInGroupsDtosByUserId(Integer userId) {
        List<RoleInGroup> rolesInGroup = roleInGroupRepository.findUserRolesInGroupsByUser_Id(userId);
        return roleInGroupMapper.roleInGroupToRoleInGroupDtos(rolesInGroup);
    }

    public List<RoleInGroup> rolesInGroupsByUserId(Integer userId) {
        return roleInGroupRepository.findUserRolesInGroupsByUser_Id(userId);
    }


    public List<RoleInGroupDto> usersAndRolesInGroup(String groupName) {
        List<RoleInGroup> usersRolesInGroup = roleInGroupRepository.findByGroup_GroupName(groupName);
        return roleInGroupMapper.roleInGroupToRoleInGroupDtos(usersRolesInGroup);
    }

    public boolean isUserInGroup(Integer userId, String groupName) {
        return roleInGroupRepository.existsByGroup_GroupNameAndUser_Id(groupName, userId);
    }

    public void addNewRoleInGroup(User user, RoleType roleType, Group group, String firstname, String lastname) {
        RoleInGroup roleInGroup = new RoleInGroup();
        roleInGroup.setUser(user);
        roleInGroup.setGroup(group);
        roleInGroup.setRoleType(roleType);
        validationService.roleExists(roleInGroupRepository.existsByRoleTypeAndGroupAndUser(roleType,group,user), firstname, lastname);
        roleInGroupRepository.save(roleInGroup);

    }

}
