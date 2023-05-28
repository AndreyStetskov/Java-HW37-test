package com.crazyemperor.homework37test.service.database;

import com.crazyemperor.homework37test.entity.User;

import java.util.List;

public interface UserDataBaseService {

    List<User> getUser();

    User addUser(User user);

    User userIsDeletedByNickname();
}
