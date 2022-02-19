package ee.bcs.folkcostumes.userManagement.user;

import ee.bcs.folkcostumes.userManagement.contact.ContactDto;
import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupDto;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupService;
import ee.bcs.folkcostumes.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    @Resource
    private ValidationService validationService;

    @Resource
    private ContactService contactService;

    @Resource
    private RoleInGroupService roleInGroupService;

    public void addNewUser(UserRequest userRequest) {
        String userName = userRequest.getUsername();
        validationService.UserNameAlreadyExists(userRepository.existsByUsername(userName));
        userRepository.save(userMapper.userRequestToUser(userRequest));
    }

    public String updateUserPassword(String userName, String newPassword) {
        User user = userRepository.findByUsername(userName);
        user.setPassword(newPassword);
        userRepository.save(user);
        return "Kasutajale " + userName + "salvestatud uud salasõna " + newPassword;
    }

    public String updateUserName(String userName, String newUserName) {
        validationService.UserNameAlreadyExists(userRepository.existsByUsername(newUserName));
        User user = userRepository.findByUsername(userName);
        user.setUsername (newUserName);
        userRepository.save(user);
        return "Kasutajanimi " + userName + " muudetud. Uus kasutajanimi on " + newUserName;
    }

    public UserDto getUserById(Integer userId) {
        User byId = userRepository.getById(userId);
        return userMapper.userToUserDto(byId);
    }

    public UserDto getUserDtoByUserName(String userName) {
        return userMapper.userToUserDto(userRepository.findByUsername(userName));
    }

    public User getUserByNames(String firstName, String lastName) {
        return contactService.getUserDtoByNames(firstName, lastName);
    }

    public User getValidUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public boolean UserNameExists(String userName) {
        return userRepository.existsByUsername(userName);
    }

    public void addUserWithContacts(UserContactDataRequest userContactDataRequest) {
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(userContactDataRequest.getUserName());
        userRequest.setPassword(userContactDataRequest.getPassword());
        addNewUser(userRequest);
        String userName = userContactDataRequest.getUserName();
        User user = userMapper.userDtoToUser(getUserDtoByUserName(userName));
        contactService.addNewContact(userContactDataRequest, user);

    }

    public List<UserRoleInGroupResponse> getRolesInAllGroupsByUser(Integer userId) {
        List<RoleInGroupDto> roles = roleInGroupService.rolesInGroups(userId);
        List<ContactDto> allContactDtos = contactService.getAllContactDtos();
        List<UserRoleInGroupResponse> rolesInGroupsByUser = new ArrayList<>();
        for (RoleInGroupDto role : roles) {
            for (ContactDto contact : allContactDtos) {
                if (contact.getUser().getId() == role.getUser().getId()) {
                    UserRoleInGroupResponse userRoles = userMapper.contactDtoToUserRoles(contact);
                    userRoles.setGroupName(role.getGroup().getGroupName());
                    userRoles.setRoleName(role.getRoleType().getName());
                }
            }
        }
        return rolesInGroupsByUser;
    }

    public List<RoleInGroupDto> getUserRolesByGroup(String groupName) {
        return roleInGroupService.usersAndRolesInGroup(groupName);
    }

}
