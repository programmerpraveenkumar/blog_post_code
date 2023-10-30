package com.youtube.oct2023.Service;

import com.youtube.oct2023.DTO.UserRequest;
import com.youtube.oct2023.Model.UserModel;
import com.youtube.oct2023.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<UserModel> getUserList(){
        return userRepo.findAll();//get all the data from user table.
    }
    public UserModel getUserById(Long userId)throws Exception{
        UserModel userModel =  userRepo.findById(userId).orElseThrow(()->new Exception("No User found"));
        return userModel;
    }
    public void updateUserById(UserRequest userRequest)throws Exception{
        UserModel userModel =  userRepo.findById(userRequest.getId()).orElseThrow(()->new Exception("No User found"));

        if(Objects.nonNull(userRequest.getEmail())){
                userModel.setEmail(userRequest.getEmail());
        }if(Objects.nonNull(userRequest.getPassword())){
                userModel.setPassword(userRequest.getPassword());
        }if(Objects.nonNull(userRequest.getName())){
                userModel.setName(userRequest.getName());
        }
        userRepo.save(userModel);
    }
    public void deleteUserById(Long userId)throws Exception{
        UserModel userModel =  userRepo.findById(userId).orElseThrow(()->new Exception("No User found"));
        userRepo.delete(userModel);
    }
    public void createUser(UserRequest userRequest)throws Exception{
        try{
            UserModel user = new UserModel();
            user.setEmail(userRequest.getEmail());
            user.setPassword(userRequest.getPassword());
            user.setName(userRequest.getName());
            userRepo.save(user);//insert the data in the mysql table.
        }catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
}
