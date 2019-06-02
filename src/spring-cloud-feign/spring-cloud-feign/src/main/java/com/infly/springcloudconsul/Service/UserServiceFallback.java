package com.infly.springcloudconsul.Service;

import com.infly.springcloudconsul.pojo.User;

public class UserServiceFallback implements UserService {
    @Override
    public User findUserById(Long id) {
        User user = new User();
        user.setId(new Long(5555));
        user.setUserName("defalutConsumerForFind");
        return null;
    }

    @Override
    public User addUser(User user) {
        user.setId(new Long(6666));
        user.setUserName("defalutConsumerForAdd");
        return null;
    }
}
