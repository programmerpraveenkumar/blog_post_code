package com.dec2023.controller;

import com.dec2023.dto.GeneralResponse;
import com.dec2023.dto.LoginRequest;
import com.dec2023.dto.RegisterRequest;
import com.dec2023.dto.SampleRequest;
import com.dec2023.model.UserModel;
import com.dec2023.service.SampleService;
import com.dec2023.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("userList")
    public ResponseEntity<?> getUserList(){
        List<UserModel> list = userService.getUserList();
        return ResponseEntity.ok(list);
    }

    @PostMapping("userCreate")
    public ResponseEntity<?> userCreate(){
        userService.createUser();
        return ResponseEntity.ok("");
    }


}