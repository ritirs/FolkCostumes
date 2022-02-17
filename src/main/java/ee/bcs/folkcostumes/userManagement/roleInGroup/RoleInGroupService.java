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

    public RoleInGroupDto addNewRoleToUser(RoleInGroupRequest request) {
        RoleInGroup roleInGroup = new RoleInGroup();
        Group groupByName = groupService.getGroupByName(request.getGroup());
        User user = contactService.getUserByFirstLastNames(request.getFirstname(), request.getLastname());
        RoleType roleType = roleTypeService.getRoleTypeByName(request.getRoleType());
        roleInGroup.setGroup(groupByName);
        roleInGroup.setUser(user);
        roleInGroup.setRoleType(roleType);
        return roleInGroupMapper.roleInGroupToRoleInGroupDto(roleInGroup);

//        RoleInGroupDto newRoleInGroupDto = new RoleInGroupDto(roleType, group, user);
//        Group groupByName = groupService.getGroupByName(request.getGroup());
//        RoleType roleType = roleTypeService.getRoleTypeByName(request.getRoleType());

//        GroupDto group = groupService.getGroupDtoByName(request.getGroup());
//        RoleTypeDto roleType = roleTypeService.getRoleTypeDtoByName(request.getRoleType());
//        UserDto user = contactService.getUserDtoByFirstLastNames(request.getFirstname(), request.getLastname());
//        RoleInGroupDto roleInGroupDto = new RoleInGroupDto(group,roleType, user);

//        User user = contactService.getUserByFirstLastNames(request.getFirstname(), request.getLastname());


//        RoleInGroup newRoleInGroup = new RoleInGroup();
//        newRoleInGroup.setGroup(groupByName);
//        newRoleInGroup.setUser(user);
//        newRoleInGroup.setRoleType(roleType);
//        roleInGroupRepository.save(newRoleInGroup);
//        return roleInGroupMapper.roleInGroupToRoleInGroupDto(newRoleInGroup);

    }



    public List<RoleInGroupDto> rolesInGroups(Integer userId) {
        List<RoleInGroup> rolesInGroup = roleInGroupRepository.findByUser_Id(userId);
        return roleInGroupMapper.roleInGroupToRoleInGroupDtos(rolesInGroup);
    }
}
