package com.youtube.oct2023;

import com.app.oct2023.DTO.LoginRequest;

public class TestUtil {
    static LoginRequest getLoginRequest(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("test@gmail.com");
        loginRequest.setPassword("test");
        return loginRequest;
    }
}
