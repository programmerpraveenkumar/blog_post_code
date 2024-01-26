package com.youtube.oct2023;


import com.app.oct2023.DTO.LoginRequest;
import com.app.oct2023.Model.UserModel;
import com.app.oct2023.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserServiceTest {

    @InjectMocks
    UserService userService;
    @Mock
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Test
    void loginTest()throws Exception{
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("test@gmail.com");
        loginRequest.setPassword("test");
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("email",loginRequest.getEmail());
        mapSqlParameterSource.addValue("password",loginRequest.getPassword());

        List<UserModel> um  = new ArrayList<UserModel>();
        UserModel um1 = new UserModel();
        um1.setEmail(loginRequest.getEmail());
        um1.setPassword(loginRequest.getPassword());
        um1.setId(1L);
        um.add(um1);

        Mockito.when(namedParameterJdbcTemplate.query(Mockito.anyString(),
                        ArgumentMatchers.any(MapSqlParameterSource.class),
                        Mockito.any(RowMapper.class)))
                .thenReturn(um);

        UserModel userModel = userService.loginValidate(loginRequest);
        assertEquals(loginRequest.getEmail(),userModel.getEmail());
        assertEquals(loginRequest.getPassword(),userModel.getPassword());
    }

    @Test
    void loginTestException()throws Exception{
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail("test@gmail.com");
        loginRequest.setPassword("test");
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("email",loginRequest.getEmail());
        mapSqlParameterSource.addValue("password",loginRequest.getPassword());

        List<UserModel> um  = new ArrayList<UserModel>();

        Mockito.when(namedParameterJdbcTemplate.query(Mockito.anyString(),
                        ArgumentMatchers.any(MapSqlParameterSource.class),
                        Mockito.any(RowMapper.class)))
                .thenReturn(um);

        Exception exception = assertThrows(Exception.class, () -> {
            userService.loginValidate(loginRequest);
        });
        assertEquals(Exception.class,exception.getClass());

//        assertEquals(loginRequest.getPassword(),userModel.getPassword());
    }


    @Test
    void registerTest()throws Exception{
        Mockito.when(namedParameterJdbcTemplate.update(Mockito.anyString(),
                        ArgumentMatchers.any(MapSqlParameterSource.class)))
                .thenReturn(1);
        assertEquals(true,userService.createUser2());
    }
}

