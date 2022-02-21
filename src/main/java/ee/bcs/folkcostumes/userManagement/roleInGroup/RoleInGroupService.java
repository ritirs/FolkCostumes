package ee.bcs.folkcostumes.userManagement.roleInGroup;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleInGroupService {

    @Resource
    private RoleInGroupMapper roleInGroupMapper;

    @Resource
    private RoleInGroupRepository roleInGroupRepository;

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

}
