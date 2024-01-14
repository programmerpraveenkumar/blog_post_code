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
public class SampleController {
    @Autowired
    SampleService sampleService;
    @Autowired
    UserService userService;

    @GetMapping("/sample")
    public String getMessage() {
        return "sample output";
    }

    @PostMapping("/sample_post")
    public String postMessage(@RequestBody SampleRequest sampleRequest) {
        return "sample output post" + sampleRequest.getEmail() + "-" + sampleRequest.getName();
    }

    @PostMapping("/login")
    public ResponseEntity<?> postMessage(@RequestBody LoginRequest loginRequest) {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            sampleService.login(loginRequest);
            generalResponse.setMessage("you are correct");
            return ResponseEntity.ok(generalResponse);
        }catch (Exception e) {
            generalResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }

    }
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest registerRequest) {
        GeneralResponse generalResponse = new GeneralResponse();
        try {
            sampleService.register(registerRequest);
            generalResponse.setMessage("Register success");
            return ResponseEntity.ok(generalResponse);
        }catch (Exception e) {
            generalResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }

    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<?> deleteByUserId(@PathVariable Long id){
        GeneralResponse generalResponse = new GeneralResponse();
        try{
            sampleService.deleteUserById(id);
            generalResponse.setMessage("User is deleted.");
            return ResponseEntity.ok(generalResponse);
        }catch (Exception e){
            generalResponse.setMessage("Error "+e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }
    }
}