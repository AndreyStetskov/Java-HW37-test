package com.crazyemperor.homework37test.service.user;

import com.crazyemperor.homework37test.entity.User;

public interface UserService {

    User add(User user);

    void delete(String name);
}
