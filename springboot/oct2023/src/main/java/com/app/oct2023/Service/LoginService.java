package com.app.oct2023.Service;

import com.app.oct2023.DTO.LoginRequestDto;
import com.app.oct2023.Model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public UserModel login(LoginRequestDto loginRequest)throws Exception{
        String sql ="select id,name,email from user where email=:email and password =:password";
        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("email",loginRequest.getEmail());
        in.addValue("password",loginRequest.getPassword());
        List<UserModel> userModelObj = namedParameterJdbcTemplate.query(sql, in, new RowMapper<UserModel>() {
            @Override
            public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserModel userModel =new UserModel();
                userModel.setName(rs.getString("name"));
                userModel.setEmail(rs.getString("email"));
                userModel.setId(rs.getLong("id"));
                return userModel;
            }
        });
        System.out.println(userModelObj.size());
        if(userModelObj.size() == 1){
            return userModelObj.get(0);
        }else{
            throw new Exception("Please provide proper username");
        }
    }
}
