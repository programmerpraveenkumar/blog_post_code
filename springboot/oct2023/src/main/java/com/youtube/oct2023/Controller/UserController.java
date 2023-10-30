package com.youtube.oct2023.Controller;

import com.youtube.oct2023.DTO.GeneralResponse;
import com.youtube.oct2023.DTO.UserRequest;
import com.youtube.oct2023.Model.UserModel;
import com.youtube.oct2023.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
localhost:8080/getUser
HTTP Methods:

get-> to get the data from server

post->post the data to server.

put->update the row.
patch->update the data

delete->delete the record.

{
"message":"sample response"
}
 */

@RestController
public class UserController {
    @Autowired
    UserService userService;

    //localhost:8080/user
    @GetMapping("user")
    public ResponseEntity<?> getName(){
        List<UserModel> userList = userService.getUserList();
        return ResponseEntity.ok(userList);
    }
    @GetMapping("user/{userId}")
    public ResponseEntity<?> getName(@PathVariable Long userId){
        try{
            UserModel user = userService.getUserById(userId);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            GeneralResponse generalResponse =new GeneralResponse();
            generalResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }
    }

    @PostMapping("user")
    public ResponseEntity<?> postName(@RequestBody UserRequest userRequest){
        GeneralResponse generalResponse =new GeneralResponse();
        try{
            userService.createUser(userRequest);//create the user in the service.
            generalResponse.setMessage("User is created");
            return ResponseEntity.ok(generalResponse);
        }catch (Exception e){
            generalResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }

    }
    @PutMapping("user")
    public ResponseEntity<?> putName(@RequestBody UserRequest userRequest){
        GeneralResponse generalResponse =new GeneralResponse();
        try{
            userService.updateUserById(userRequest);//create the user in the service.
            generalResponse.setMessage("User is updated");
            return ResponseEntity.ok(generalResponse);
        }catch (Exception e){
            generalResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }
    }

    @DeleteMapping("user/{userId}")
    public ResponseEntity<?>  deleteName(@PathVariable Long userId){
        GeneralResponse generalResponse =new GeneralResponse();
        try{
            userService.deleteUserById(userId);//create the user in the service.
            generalResponse.setMessage("User is deleted");
            return ResponseEntity.ok(generalResponse);
        }catch (Exception e){
            generalResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(generalResponse);
        }
    }
}
