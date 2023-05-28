package com.crazyemperor.homework37test.service.user.implemlementation;

import com.crazyemperor.homework37test.entity.Sex;
import com.crazyemperor.homework37test.entity.User;
import com.crazyemperor.homework37test.service.database.UserDataBaseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserDataBaseService userDataBaseService;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void add_twoUsersBecame_success() {
        //        given

        User user = new User();

        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "Ernst Handel", null, null, 20, Sex.MALE, null, null, null, "Portugal", 25, false));


        int expected = 2;


//        when

        when(userDataBaseService.addUser(any(User.class))).thenReturn((User) userList);

        userList.add(userService.add(user));

        int actual = userList.size();


//        then

        assertEquals(expected, actual);
    }

    @Test
    void delete_oneUser_success() {

        //        given

        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "Ernst Handel", null, null, 20, Sex.MALE, null, null, null, "Portugal", 25, false));
        userList.add(new User(2, "Folk och fä HB", "Maria", null, 25, Sex.INTERSEX, null, "Bräcke", null, "Sweden", 200, false));


        int expected = 1;


//        when

        when(userDataBaseService.userIsDeletedByNickname().thenReturn();

        userService.delete("Ernst Handel");

        int actual = userList.size();


//        then

        assertEquals(expected, actual);

    }
}