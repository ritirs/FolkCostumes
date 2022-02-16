package ee.bcs.folkcostumes.userManagement.contact;

import ee.bcs.folkcostumes.userManagement.user.User;
import ee.bcs.folkcostumes.userManagement.user.UserDataRequest;
import ee.bcs.folkcostumes.userManagement.user.UserDto;
import ee.bcs.folkcostumes.userManagement.user.UserService;
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

//    public void addNewUser(UserDataRequest userDataRequest) {
//        String newUserName = userDataRequest.getUsername();
//
//        Contact contact = contactMapper.userDataRequestToContact(userDataRequest);
//        contactRepository.save(contact);
//
//    }

    public ContactDto addNewContact(UserDataRequest userDataRequest, User newUser) {
        Contact newContact = new Contact();
        newContact.setFirstname(userDataRequest.getFirstname());
        newContact.setLastname(userDataRequest.getLastname());
        newContact.setEmail(userDataRequest.getEmail());
        newContact.setTelephone(userDataRequest.getTelephone());
        newContact.setBirthDate(userDataRequest.getBirthDate());
        newContact.setAddress(userDataRequest.getAddress());
        newContact.setUser(newUser);
        contactRepository.save(newContact);
        return contactMapper.contactToContactDto(newContact);
    }
}
