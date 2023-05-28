package com.crazyemperor.homework37test.controller;

import com.crazyemperor.homework37test.entity.User;
import com.crazyemperor.homework37test.service.newpartner.NewPartnerService;
import com.crazyemperor.homework37test.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class DatingController {

    private final NewPartnerService newPartnerService;

    private final UserService userService;



    @GetMapping(value = "/new-match")
    public ResponseEntity<User> getNewMatch() {
        User user = newPartnerService.getNewMatch();

        return user != null ? ResponseEntity.ok(user) : ResponseEntity.badRequest().build();
    }

    @GetMapping(value = "/new-user")
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(value = "/user_delete/{name}")
    public void deleteUser(@PathVariable String name) {

        userService.delete(name);
    }
}
