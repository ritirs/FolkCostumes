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

    @Resource
    private ContactService contactService;

    @Resource
    private GroupService groupService;

    @Resource
    private RoleTypeService roleTypeService;

//    public RoleInGroupDto addNewRoleToUser(RoleInGroupRequest request) {
//        RoleInGroup roleInGroup = new RoleInGroup();
//        Group groupByName = groupService.getGroupByName(request.getGroup());
//        User user = contactService.getUserByFirstLastNames(request.getFirstname(), request.getLastname());
//        RoleType roleType = roleTypeService.getRoleTypeByName(request.getRoleType());
//        roleInGroup.setGroup(groupByName);
//        roleInGroup.setUser(user);
//        roleInGroup.setRoleType(roleType);
//        return roleInGroupMapper.roleInGroupToRoleInGroupDto(roleInGroup);
//    }
//    public List<RoleInGroupDto> rolesInGroups(Integer userId) {
//        List<RoleInGroup> rolesInGroup = roleInGroupRepository.finduserRolesByUser_Id(userId);
//        return roleInGroupMapper.roleInGroupToRoleInGroupDtos(rolesInGroup);
//    }

    public List<RoleInGroup> usersAndRolesInGroup(String groupName) {
        return roleInGroupRepository.findByGroup_GroupName(groupName);
    }

    // kas user on grupi liige
    public boolean isUserInGroup(Integer userId, String groupName) {
        Integer groupId = (groupService.getGroupByName(groupName).getId());
        return roleInGroupRepository.existsByGroup_GroupName(groupName);
    }

}
