package ee.bcs.folkcostumes.userManagement.user;

import ee.bcs.folkcostumes.userManagement.contact.ContactDto;
import ee.bcs.folkcostumes.userManagement.contact.ContactResponse;
import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import ee.bcs.folkcostumes.userManagement.group.Group;
import ee.bcs.folkcostumes.userManagement.group.GroupService;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroup;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupDto;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupRequest;
import ee.bcs.folkcostumes.userManagement.roleInGroup.RoleInGroupService;
import ee.bcs.folkcostumes.userManagement.roleType.RoleType;
import ee.bcs.folkcostumes.userManagement.roleType.RoleTypeService;
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

    @Resource
    private GroupService groupService;

    @Resource
    private RoleTypeService roleTypeService;

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
        user.setUsername(newUserName);
        userRepository.save(user);
        return "Kasutajanimi " + userName + " muudetud. Uus kasutajanimi on " + newUserName;
    }


    public User getValidUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public void addUserWithContacts(UserContactDataRequest userContactDataRequest) {
        validationService.UserNameAlreadyExists(userRepository.existsByUsername(userContactDataRequest.getUsername()));
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(userContactDataRequest.getUsername());
        userRequest.setPassword(userContactDataRequest.getPassword());
        addNewUser(userRequest);
        String username = userContactDataRequest.getUsername();
        User user = userRepository.findByUsername(username);
        contactService.addNewContact(userContactDataRequest, user);
    }

    public List<UserRoleInGroupResponse> getRolesInAllGroupsByUser(Integer userId) {
        ContactDto contactdto = contactService.getContactDtoByUserId(userId);
        List<RoleInGroupDto> roles = roleInGroupService.rolesInGroupsDtosByUserId(userId);
        List<UserRoleInGroupResponse> rolesListInGroupsByUser = new ArrayList<>();
        for (RoleInGroupDto role : roles) {
            UserRoleInGroupResponse userRolesInAllGroups = userMapper.contactDtoToUserRoles(contactdto);
            userRolesInAllGroups.setGroupName(role.getGroup().getGroupName());
            userRolesInAllGroups.setRoleName(role.getRoleType().getName());
            rolesListInGroupsByUser.add(userRolesInAllGroups);
        }
        return rolesListInGroupsByUser;
    }

    public ContactResponse getUserContact(User user) {
        return contactService.getUserContact(user);
    }

    public List<ContactResponse> getContactsByGroupName(String groupName) {
        List<ContactResponse> allContacts = contactService.getAllContacts();
        List<ContactResponse> contactsOfGroup = new ArrayList<>();
        for (ContactResponse contact : allContacts) {
            User user = contactService.getUserByNames(contact.getFirstname(), contact.getLastname());
            if (roleInGroupService.isUserInGroup(user.getId(), groupName)) {
                contactsOfGroup.add(contact);
            }
        }
        return contactsOfGroup;
    }




    public UserPassword getUserPassword(User user) {
        return userMapper.userToUserPassword(user);
    }

    public List<UserPassword> getUsersPasswordsByGroup(String groupName) {
        List<User> users = userRepository.findAll();
        List<UserPassword> usersPasswords = new ArrayList<>();
        for (User user : users) {
            if (roleInGroupService.isUserInGroup(user.getId(), groupName)) {
                ContactResponse contact = contactService.getUserContact(user);
                UserPassword userPassword = userMapper.userToUserPassword(user);
//                userPassword.setGroupName(groupName);
                userPassword.setFirstname(contact.getFirstname());
                userPassword.setLastname(contact.getLastname());
                usersPasswords.add(userPassword);
            }
        }
        return usersPasswords;
    }

    public void addRoleToUser(RoleInGroupRequest roleInGroupRequest) {
        User user = contactService.getUserByNames(roleInGroupRequest.getFirstname(), roleInGroupRequest.getLastname());
        Group group = groupService.getGroupByName(roleInGroupRequest.getGroup());
        RoleType roleType = roleTypeService.getRoleTypeByName(roleInGroupRequest.getRoleType());
        roleInGroupService.addNewRoleInGroup(user, roleType,group, roleInGroupRequest.getFirstname(), roleInGroupRequest.getLastname());






    }
}
