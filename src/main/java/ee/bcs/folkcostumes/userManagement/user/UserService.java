package ee.bcs.folkcostumes.userManagement.user;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserRepository userRepository;

    public User addNewUser(String username) {
        User newUser = new User();
        newUser.setUsername(username);
        userRepository.save(newUser);
        return newUser;
    }

    public UserDto getUserById(Integer userId) {
        User byId = userRepository.getById(userId);
        UserDto userDto = userMapper.userToUserDto(byId);
        return userDto;
    }

    public UserDto getUserByUserName(String userName) {
        User byUserName = userRepository.findByUsername(userName);
        return userMapper.userToUserDto(byUserName);
    }

}
