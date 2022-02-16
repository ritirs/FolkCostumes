package ee.bcs.folkcostumes.userManagement.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;
    private String username;

    public User addNewUser(String username) {
        User newUser = new User();
        newUser.setUsername(username);
        userRepository.save(newUser);
        return newUser;
    }

    public UserDto getUsernameById(Integer userId) {
        User byId = userRepository.getById(userId);
        UserDto userDto = userMapper.userToUserDto(byId);
        return userDto;
    }

}
