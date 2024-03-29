package com.dec2023.service;

import com.dec2023.dto.LoginRequest;
import com.dec2023.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    NamedParameterJdbcTemplate namedJdbcTemplate;


        public List<UserModel> getUserList(){
                String sql ="select name,email from user";
              List<UserModel> userModelList = namedJdbcTemplate.query(sql, new RowMapper<UserModel>() {
                    @Override
                    public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
                        UserModel userModel =new UserModel();
                        userModel.setName(rs.getString("name"));
                        userModel.setEmail(rs.getString("email"));
                        return userModel;
                    }
                });

              return userModelList;
        }
    public void createUser(){
        String sql ="insert into user(id,name,email,password)values(:id,:name,:email,:password)";

        MapSqlParameterSource in = new MapSqlParameterSource();
        in.addValue("name","test");
        in.addValue("email","test@gmail.com");
        in.addValue("password","testpwd");
        in.addValue("id",2);

        namedJdbcTemplate.update(sql,in);
    }
}
