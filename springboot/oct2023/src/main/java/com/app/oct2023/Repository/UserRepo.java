package com.app.oct2023.Repository;

import com.app.oct2023.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserModel,Long> {
}
