package ee.bcs.folkcostumes.logIn;

import ee.bcs.folkcostumes.userManagement.contact.ContactService;
import ee.bcs.folkcostumes.userManagement.user.UserDto;
import ee.bcs.folkcostumes.userManagement.user.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class LoginService {

    @Resource
    private ContactService contactService;

    @Resource
    private UserService userService;

    public LoginResponse login(String userName, String password) {
        UserDto userByUserName = userService.getUserByUserName(userName);





        return null;
    }
}
