package com.dec2023.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    String email;
    String name;
    String password;
}
