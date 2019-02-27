package com.mackittipat.bootaop;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    @LogExecutionTime(name = "Mac")
    public User findUser(int id) {
        User user = new User();
        user.setId(id);
        user.setName("Mac");
        return user;
    }
}
