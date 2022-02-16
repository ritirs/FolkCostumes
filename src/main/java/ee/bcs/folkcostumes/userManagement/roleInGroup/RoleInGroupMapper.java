package ee.bcs.folkcostumes.userManagement.roleInGroup;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleInGroupMapper {
    RoleInGroup roleInGroupDtoToRoleInGroup(RoleInGroupDto roleInGroupDto);

    RoleInGroupDto roleInGroupToRoleInGroupDto(RoleInGroup roleInGroup);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRoleInGroupFromRoleInGroupDto(RoleInGroupDto roleInGroupDto, @MappingTarget RoleInGroup roleInGroup);
}
