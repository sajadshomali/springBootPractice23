package ir.sajjad.springbootsession23.service;

import ir.sajjad.springbootsession23.dto.request.UserLoginRequest;
import ir.sajjad.springbootsession23.dto.request.UserRequest;
import ir.sajjad.springbootsession23.dto.response.UserResponse;
import ir.sajjad.springbootsession23.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


public interface UserService {
    UserResponse save(UserRequest user);

    void login(UserLoginRequest userLoginRequest);

    void changeUserStaues(Long userId, boolean enable);

    Page<User> userList(Pageable pageable);
}
