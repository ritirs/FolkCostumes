package ee.bcs.folkcostumes.userManagement.contact;

import ee.bcs.folkcostumes.userManagement.user.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ContactService {

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private ContactRepository contactRepository;


    public void addNewContact(UserContactDataRequest userDataRequest, User newUser) {
        Contact newContact = contactMapper.userDataRequestToContact(userDataRequest);
        newContact.setUser(newUser);
        contactRepository.save(newContact);
    }

    public ContactDto getContactDtoByName(String firstName, String lastName) {
        Contact contact = contactRepository.findByFirstnameAndLastname(firstName, lastName);
        return contactMapper.contactToContactDto(contact);
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

    public List<ContactResponse> getAllContacts() {
        List<Contact> allContacts = contactRepository.findAll();
        return contactMapper.contactsToContactResponses(allContacts);
    }

    public List<ContactDto> getAllContactDtos() {
        List<Contact> allContacts = contactRepository.findAll();
        return contactMapper.contactsToContactDtos(allContacts);
    }

    public User getUserDtoByNames(String firstName, String lastName) {
        Contact contact = contactRepository.findByFirstnameAndLastname(firstName, lastName);
        return contact.getUser();
    }
}
