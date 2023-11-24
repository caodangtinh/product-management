package com.tinhcao.productmanagement.service;

import com.tinhcao.productmanagement.controller.dto.UserDTO;
import com.tinhcao.productmanagement.entity.User;
import com.tinhcao.productmanagement.exception.ResourceExistException;
import com.tinhcao.productmanagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(UserDTO userDTO) {
        if(getUserByUsername(userDTO.getUsername()).isPresent()) {
            throw new ResourceExistException("Username already exist");
        }
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setCreatedDate(LocalDateTime.now());
        return userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
