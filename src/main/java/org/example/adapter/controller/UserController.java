package org.example.adapter.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.adapter.controller.dto.*;
import org.example.application.api.service.UserService;
import org.example.domain.User;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    private final ModelMapper modelMapper;

    @PostMapping
    public CreateUserResponse create(@RequestBody CreateUserRequest request) {
        User user = modelMapper.map(request, User.class);
        user = userService.create(user);
        CreateUserResponse response = modelMapper.map(user, CreateUserResponse.class);
        return response;
    }

    @GetMapping("/{uuid}")
    public GetUserResponse getUser(@PathVariable String uuid) {
        log.warn("HELOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO, {}", uuid);
        User result = userService.get(uuid);
        return modelMapper.map(result, GetUserResponse.class);
    }

    @PutMapping("/{uuid}")
    public UpdateUserResponse update(@RequestBody UpdateUserRequest request) throws Exception {
        User user = modelMapper.map(request, User.class);
        user = userService.update(user);
        UpdateUserResponse updateUserResponse = modelMapper.map(user, UpdateUserResponse.class);
        return updateUserResponse;
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid){
        userService.delete(uuid);
    }
}
