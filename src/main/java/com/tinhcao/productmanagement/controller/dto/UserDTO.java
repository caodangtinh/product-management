package com.tinhcao.productmanagement.controller.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO {
    @NotNull(message = "Username can not be null")
    @NotBlank(message = "Username can not be blank")
    private String username;

    @NotNull(message = "Password can not be null")
    @NotBlank(message = "Password can not be blank")
    private String password;
}
