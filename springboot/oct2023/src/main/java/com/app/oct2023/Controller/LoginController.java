package com.app.oct2023.Controller;

import com.app.oct2023.DTO.GeneralResponse;
import com.app.oct2023.DTO.LoginRequestDto;
import com.app.oct2023.Model.UserModel;
import com.app.oct2023.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto){
        GeneralResponse response = new GeneralResponse();
        try{
            UserModel usermodel = loginService.login(loginRequestDto);
            return ResponseEntity.ok(usermodel);
        }catch (Exception e){
            response.setMessage("Error "+e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
