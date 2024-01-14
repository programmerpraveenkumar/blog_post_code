package com.dec2023.repository;

import com.dec2023.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Long> {
    @Query("select um from UserModel um where um.email=:email and um.password =:password")
    Optional<UserModel> login(@Param("email") String email, @Param("password") String password);
    @Query("select um from UserModel um where um.email=:email")
    Optional<UserModel> getByEmail(@Param("email") String email);
}
