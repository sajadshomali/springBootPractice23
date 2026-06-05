package ir.sajjad.springbootsession23.service;

import ir.sajjad.springbootsession23.dto.request.UserLoginRequest;
import ir.sajjad.springbootsession23.dto.request.UserRequest;
import ir.sajjad.springbootsession23.dto.response.UserResponse;
import ir.sajjad.springbootsession23.exception.MyRuleException;
import ir.sajjad.springbootsession23.model.User;
import ir.sajjad.springbootsession23.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        Optional<User> byUsername = userRepository.findByUsername(userRequest.getUsername());
        if (byUsername.isPresent()) {
            throw new MyRuleException("username.is.exist");
        }
        return mapUserToUserResponse(userRepository.save(mapUserRequestToUser(userRequest)));
    }

    @Override
    public void login(UserLoginRequest userLoginRequest) {
        User user = userRepository.findByUsername(userLoginRequest.getUsername()).orElseThrow(
                () -> new MyRuleException("User.not.found"));
        if (!user.getPassword().equals(userLoginRequest.getPassword())){
            throw new MyRuleException("User.not.found");
        }
    }

    @Override
    public void changeUserStaues(Long userId, boolean enable) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new MyRuleException("User.not.found"));
        user.setEnabled(enable);
        userRepository.save(user);
    }

    @Override
    public Page<User> userList(Pageable pageable) {
        return userRepository.findAll(pageable);

    }

    private UserResponse mapUserToUserResponse(User user) {
        return UserResponse.builder().id(user.getId())
                .username(user.getUsername())
                .enabled(user.isEnabled())
                .build();
    }

    private User mapUserRequestToUser(UserRequest userRequest) {
        return User.builder().username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .enabled(true)
                .build();
    }
}
