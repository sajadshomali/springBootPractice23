package ir.sajjad.springbootsession23.service;

import ir.sajjad.springbootsession23.dto.request.UserRequest;
import ir.sajjad.springbootsession23.dto.response.UserResponse;
import ir.sajjad.springbootsession23.exception.MyRuleException;
import ir.sajjad.springbootsession23.model.User;
import ir.sajjad.springbootsession23.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    private UserResponse mapUserToUserResponse(User user) {
        return UserResponse.builder().id(user.getId())
                .username(user.getUsername())
                .build();
    }

    private User mapUserRequestToUser(UserRequest userRequest) {
        return User.builder().username(userRequest.getUsername())
                .password(userRequest.getPassword())
                .build();
    }
}
