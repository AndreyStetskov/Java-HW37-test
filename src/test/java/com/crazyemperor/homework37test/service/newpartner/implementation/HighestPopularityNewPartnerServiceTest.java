package com.crazyemperor.homework37test.service.newpartner.implementation;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HighestPopularityNewPartnerServiceTest {

    @Mock
    private UserDataBaseService userDataBaseService;
    @InjectMocks
    private HighestPopularityNewPartnerService highestPopularityNewPartnerService;

    @Test
    void getNewMatch_twoUsersWithDifferentPoints_success() {
//        given

        User expected = new User(2, "Folk och fä HB", "Maria", null, 25, Sex.INTERSEX, null, "Bräcke", null, "Sweden", 200, false);

        List<User> userList = new ArrayList<>();

        userList.add(new User(1, "Ernst Handel", null, null, 20, Sex.MALE, null, null, null, "Portugal", 25, false));
        userList.add(expected);


//        when

        when(userDataBaseService.getUser()).thenReturn(userList);

        User actual = highestPopularityNewPartnerService.getNewMatch();


//        then

        assertEquals(expected, actual);
    }
}