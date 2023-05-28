package com.crazyemperor.homework37test.service.user.implemlementation;

import com.crazyemperor.homework37test.entity.User;
import com.crazyemperor.homework37test.service.database.UserDataBaseService;
import com.crazyemperor.homework37test.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDataBaseService userDataBaseService;

    @Override
    @CacheEvict(value = "USERS", key = "#id")
    @Transactional
    public User add(User user) {
        log.info("Now create a new user");

        user.setNickname("IslandTrading");
        user.setFirstName("Helen");
        user.setLastName("Bennett");
        user.setCountry("Belgium");
        user.setPoint(0);
        user.setBlocked(false);

        log.info("The user is being created");
        return userDataBaseService.addUser(user);
    }

    @Override
    public void delete(String nickname) {

        log.info("Are you sure you want to delete this user?");
        log.info("The user is being deleted");

        userDataBaseService.userIsDeletedByNickname();

        log.info("The user was deleted");
    }
}
