package ir.sajjad.springbootsession23.service;

import ir.sajjad.springbootsession23.dto.request.UserRequest;
import ir.sajjad.springbootsession23.dto.response.UserResponse;


public interface UserService {
    UserResponse save(UserRequest user);
}
