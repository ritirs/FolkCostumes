package ee.bcs.folkcostumes.group;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface GroupMapper {
    Group groupDtoToGroup(GroupDto groupDto);

    GroupDto groupToGroupDto(Group group);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGroupFromGroupDto(GroupDto groupDto, @MappingTarget Group group);
}
