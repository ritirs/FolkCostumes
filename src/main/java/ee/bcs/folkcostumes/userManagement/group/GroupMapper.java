package ee.bcs.folkcostumes.userManagement.group;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface GroupMapper {
    Group groupDtoToGroup(GroupDto groupDto);

    GroupDto groupToGroupDto(Group group);

    List<GroupDto> groupToGroupDto(List<Group> group);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateGroupFromGroupDto(GroupDto groupDto, @MappingTarget Group group);

}
