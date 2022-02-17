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

    public ContactDto addNewContact(UserDataRequest userDataRequest, User newUser) {
        Contact newContact = contactMapper.userDataRequestToContact(userDataRequest);
        newContact.setUser(newUser);
        contactRepository.save(newContact);
        return contactMapper.contactToContactDto(newContact);
    }

    public Integer getUserIdByName(String firstName, String lastName) {
        return contactRepository.findByName(firstName, lastName);
    }
}
