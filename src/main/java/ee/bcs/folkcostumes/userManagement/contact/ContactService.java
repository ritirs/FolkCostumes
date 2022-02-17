package ee.bcs.folkcostumes.userManagement.contact;

import ee.bcs.folkcostumes.userManagement.user.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private ContactRepository contactRepository;

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public ContactDto addNewContact(UserDataRequest userDataRequest, UserDto newUser) {
        Contact newContact = contactMapper.userDataRequestToContact(userDataRequest);
        newContact.setUser(userMapper.userDtoToUser(newUser));
        contactRepository.save(newContact);
        return contactMapper.contactToContactDto(newContact);
    }

    public ContactDto getContactDtoByName(String firstName, String lastName) {
        Contact contact = contactRepository.findByFirstnameAndLastname(firstName, lastName);
        return contactMapper.contactToContactDto(contact);
    }

    public User getUserByFirstLastNames (String firstName, String lastName) {
        Contact contact = contactRepository.findByFirstnameAndLastname(firstName, lastName);
        return contact.getUser();
    }

    public UserDto getUserDtoByFirstLastNames (String firstName, String lastName) {
        Contact contact = contactRepository.findByFirstnameAndLastname(firstName, lastName);
        return userMapper.userToUserDto(contact.getUser());
    }

    public ContactDto getContactDtoByUserId(Integer userId) {
        Contact contact = contactRepository.findByUser_Id(userId);
        return contactMapper.contactToContactDto(contact);
    }

    //LoginDto jaoks
    public String getFirstNameById(Integer userId) {
        Contact byUser_id = contactRepository.findByUser_Id(userId);
        return byUser_id.getFirstname();
    }
    //LoginDto jaoks
    public String getLastNameById(Integer userId) {
        Contact byUser_id = contactRepository.findByUser_Id(userId);
        return byUser_id.getLastname();
    }

}
