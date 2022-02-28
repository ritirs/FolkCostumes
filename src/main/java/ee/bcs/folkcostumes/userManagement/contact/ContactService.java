package ee.bcs.folkcostumes.userManagement.contact;

import ee.bcs.folkcostumes.userManagement.user.*;
import ee.bcs.folkcostumes.userManagement.userReport.FirstLastNames;
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

    public void updateUserContacts(ContactResponse contactResponse) {
        Contact contact = contactRepository.findByFirstnameAndLastname(contactResponse.getFirstname(), contactResponse.getLastname());
        contactRepository.save(contactMapper.contactResponseToContact(contactResponse));
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

    public User getUserByNames(String firstname, String lastname) {
        Contact contact = contactRepository.findByFirstnameAndLastname(firstname, lastname);
        return contact.getUser();
    }

    public ContactResponse getUserContact(User user) {
        Contact contact = contactRepository.findByUser_Id(user.getId());
        return contactMapper.contactToContactResponse(contact);
    }

    public List<ContactDto> getAllContactDtos() {
        List<Contact> allContacts = contactRepository.findAll();
        return contactMapper.contactsToContactDtos(allContacts);
    }

    public List<FirstLastNames> getUsersByNames() {
        return contactMapper.contactsToFirstLastName(contactRepository.findAll());
    }

    public Boolean userWithNamesExists(UserContactDataRequest userContactDataRequest) {
        return contactRepository.existsByFirstnameAndLastname(userContactDataRequest.getFirstname(), userContactDataRequest.getLastname());
    }
}
