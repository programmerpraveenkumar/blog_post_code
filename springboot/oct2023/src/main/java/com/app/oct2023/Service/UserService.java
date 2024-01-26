package com.app.oct2023.Service;

import com.app.oct2023.DTO.LoginRequest;
import com.app.oct2023.DTO.UserRequest;
import com.app.oct2023.Model.UserModel;
import com.app.oct2023.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    NamedParameterJdbcTemplate namedJdbcTemplate;

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

    public UserModel loginValidate(LoginRequest loginRequest)throws Exception{
        String sql ="select name,email from user where email=:email and password =:password";
        MapSqlParameterSource in = new MapSqlParameterSource();
//        in.addValue("email",loginRequest.getEmail());
//        in.addValue("password",loginRequest.getPassword());
        List<UserModel> userModelObj = namedJdbcTemplate.query(sql, in, new RowMapper<UserModel>() {
            @Override
            public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserModel userModel =new UserModel();
                userModel.setName(rs.getString("name"));
                userModel.setEmail(rs.getString("email"));
                return userModel;
            }
        });
        if(userModelObj.size() == 1){
            return userModelObj.get(0);
        }else{
            throw new Exception("Please provide proper username");
        }

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
    public boolean createUser2(){
        String sql ="insert into user(id,name,email,password)values(:id,:name,:email,:password)";

        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("name","test");
        in.addValue("email","test@gmail.com");
        in.addValue("password","testpwd");
        in.addValue("id",2);
        try{
            namedJdbcTemplate.update(sql,in);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
