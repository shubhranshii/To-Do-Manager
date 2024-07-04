package com.shubhranshi.todo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegisterDto {

    @NotEmpty
    String username;
    @NotEmpty
    String password;
    @NotEmpty
    String email;
    @NotEmpty
    String confirmPassword;
}
