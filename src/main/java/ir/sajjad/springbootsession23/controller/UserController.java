package ir.sajjad.springbootsession23.controller;

import ir.sajjad.springbootsession23.dto.request.UserLoginRequest;
import ir.sajjad.springbootsession23.dto.request.UserRequest;
import ir.sajjad.springbootsession23.dto.response.UserResponse;
import ir.sajjad.springbootsession23.model.User;
import ir.sajjad.springbootsession23.service.UserService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserResponse> save(@RequestBody @Valid UserRequest userRequest){
        return ResponseEntity.ok(userService.save(userRequest));
    }

    @GetMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest){
            userService.login(userLoginRequest);
            return ResponseEntity.ok().build();
    }

    @PutMapping("/status/{enable}/{userId}")
    public ResponseEntity<?> changeEnableUser(@PathVariable boolean enable,@PathVariable Long userId){
        userService.changeUserStaues(userId,enable);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public ResponseEntity<Page<User>> userList(Pageable pageable){
        return ResponseEntity.ok(userService.userList(pageable));
    }

}
