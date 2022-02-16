package ee.bcs.folkcostumes.userManagement.contact;

import ee.bcs.folkcostumes.userManagement.UserDataRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    private ContactMapper contactMapper;

    @Resource
    private ContactRepository contactRepository;

    public void addNewUser(UserDataRequest userDataRequest) {
        Contact contact = contactMapper.userDataRequestToContact(userDataRequest);
        contactRepository.save(contact);
    }
}
