package kaveski.yonathan.todoserver.User;

import kaveski.yonathan.todoserver.User.dto.request.UserRequestPatchBody;
import kaveski.yonathan.todoserver.User.dto.request.UserRequestPostBody;
import kaveski.yonathan.todoserver.User.dto.response.UserResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserResponseBody save(UserRequestPostBody userDTO) {
        User _user = UserMapper.INSTANCE.toUser(userDTO);
        String password = _user.getPassword();
        System.out.println(password);
        _user.setRoles("ROLE_USER");
        _user.setLoginWith("CREATED");

        return UserMapper.INSTANCE.toDto(userRepository.save(_user));
    }

    public Optional<UserResponseBody> searchById(Long id) {
        Optional<UserResponseBody> userDTO = Optional.empty();
        Optional<User> _user = userRepository.findById(id);
        if(_user.isPresent())
            userDTO = Optional.of(UserMapper.INSTANCE.toDto(_user.get()));

        return userDTO;
    }

    public Optional<UserResponseBody> update(Long id, UserRequestPatchBody userDTO) {
        Optional<User> user = userRepository.findById(id);
        Optional<UserResponseBody> response = Optional.empty();
        if(user.isEmpty()) return response;
        User _user = user.get();
        UserMapper.INSTANCE.update(_user, userDTO);

        response = Optional.of(UserMapper.INSTANCE.toDto(userRepository.save(_user)));
        return response;
    }

    public Iterable<User> searchAll() {
        return userRepository.findAll();
    }


}
