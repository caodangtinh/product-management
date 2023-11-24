package com.tinhcao.productmanagement.controller;

import com.tinhcao.productmanagement.controller.dto.UserDTO;
import com.tinhcao.productmanagement.entity.User;
import com.tinhcao.productmanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("add")
    public ResponseEntity<Long> createUser(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.createUser(userDTO);
        return ResponseEntity.ok(user.getId());
    }
}
