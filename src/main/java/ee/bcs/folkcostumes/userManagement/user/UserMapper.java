package ee.bcs.folkcostumes.userManagement.user;

import ee.bcs.folkcostumes.userManagement.contact.ContactDto;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User userDtoToUser(UserDto userDto);

    UserDto userToUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserDto(UserDto userDto, @MappingTarget User user);

    User userRequestToUser(UserRequest userRequest);
    UserRoleInGroupResponse contactDtoToUserRoles(ContactDto contact);
    UserPassword userToUserPassword(User user);
}
