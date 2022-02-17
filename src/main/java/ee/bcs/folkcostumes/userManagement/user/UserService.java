package ee.bcs.folkcostumes.userManagement.user;

import ee.bcs.folkcostumes.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    @Resource
    private ValidationService validationService;

//    public User addNewUser(String username) {
//        User newUser = new User();
//        newUser.setUsername(username);
//        userRepository.save(newUser);
//        return newUser;
//    }

    public UserDto addNewUser(UserDataRequest userDataRequest) {
        User newUser = userMapper.UserByUserDataRequest(userDataRequest);
        userRepository.save(newUser);
        return userMapper.userToUserDto(newUser);
    }

    public UserDto getUserById(Integer userId) {
        User byId = userRepository.getById(userId);
        return userMapper.userToUserDto(byId);
    }

    public User getUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    public User getValidUserName(String userName) {
        User userByUserName = userRepository.findByUsername(userName);
        validationService.userExists(Optional.ofNullable(userByUserName), userName);
        return null;
    }

}
