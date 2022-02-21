package ee.bcs.folkcostumes.logIn;

import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroup;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface GroupsAndRolesMapper {
    @Mapping(source = "roleTypeName", target = "roleType.name")
    @Mapping(source = "groupGroupName", target = "group.groupName")
    RoleInGroup groupsAndRolesToRoleInGroup(GroupsAndRoles groupsAndRoles);

    @InheritInverseConfiguration(name = "groupsAndRolesToRoleInGroup")
    GroupsAndRoles roleInGroupToGroupsAndRoles(RoleInGroup roleInGroup);

    @InheritConfiguration(name = "groupsAndRolesToRoleInGroup")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRoleInGroupFromGroupsAndRoles(GroupsAndRoles groupsAndRoles, @MappingTarget RoleInGroup roleInGroup);
}
