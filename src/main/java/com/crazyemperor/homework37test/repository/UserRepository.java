package com.crazyemperor.homework37test.repository;

import com.crazyemperor.homework37test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Integer> {

    User deleteByNickname();

}
