package com.dec2023.service;

import com.dec2023.dto.LoginRequest;
import com.dec2023.dto.RegisterRequest;
import com.dec2023.model.UserModel;
import com.dec2023.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SampleService {

    @Autowired
    UserRepo userRepo;
    public boolean login(LoginRequest loginRequest) throws  Exception{
            UserModel  userModel = userRepo.login(loginRequest.getEmail(),loginRequest.getPassword()).orElseThrow(()->new Exception("No user found.."));
            return true;

//        if (loginRequest.getEmail().equals("test@gmail.com")
//                && loginRequest.getPassword().equals("test")) {
//            return true;
//        } else {
//           throw new Exception("you are wrong!!!");
//        }
    }

    public boolean register(RegisterRequest registerRequest) throws  Exception{
        //if email is exist.should throw the error.
        Optional<UserModel>  userModelopt = userRepo.getByEmail(registerRequest.getEmail());
        if(!userModelopt.isPresent()){
            UserModel userModel1 = new UserModel();
            userModel1.setEmail(registerRequest.getEmail());
            userModel1.setName(registerRequest.getName());
            userModel1.setPassword(registerRequest.getPassword());
            userRepo.save(userModel1);
            return true;
        }else{
            throw new Exception("Email is already exist.!!");
        }
//        if (loginRequest.getEmail().equals("test@gmail.com")
//                && loginRequest.getPassword().equals("test")) {
//            return true;
//        } else {
//           throw new Exception("you are wrong!!!");
//        }
    }

    public List<UserModel> getUserList(){
        List<UserModel> userList = userRepo.findAll();
        return  userList;
    }
    public Boolean deleteUserById(Long id)throws Exception{
        UserModel userModel = userRepo.findById(id).orElseThrow(()->new Exception("NO User found"));
        userRepo.delete(userModel);
        return  true;
    }
}
