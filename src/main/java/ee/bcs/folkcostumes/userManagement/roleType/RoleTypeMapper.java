package ee.bcs.folkcostumes.userManagement.roleType;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface RoleTypeMapper {
    RoleType roleTypeDtoToRoleType(RoleTypeDto roleTypeDto);

    RoleTypeDto roleTypeToRoleTypeDto(RoleType roleType);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateRoleTypeFromRoleTypeDto(RoleTypeDto roleTypeDto, @MappingTarget RoleType roleType);
}
