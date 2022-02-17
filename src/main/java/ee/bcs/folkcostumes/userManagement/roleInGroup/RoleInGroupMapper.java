package ee.bcs.folkcostumes.userManagement.roleInGroup;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleInGroupMapper {
    RoleInGroup roleInGroupDtoToRoleInGroup(RoleInGroupDto roleInGroupDto);

    RoleInGroupDto roleInGroupToRoleInGroupDto(RoleInGroup roleInGroup);
   List<RoleInGroupDto> roleInGroupToRoleInGroupDtos(List<RoleInGroup> roleInGroup);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRoleInGroupFromRoleInGroupDto(RoleInGroupDto roleInGroupDto, @MappingTarget RoleInGroup roleInGroup);
}
