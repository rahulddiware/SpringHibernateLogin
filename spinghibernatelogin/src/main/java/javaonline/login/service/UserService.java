package javaonline.login.service;

import javaonline.login.model.User;

public interface UserService {
    void save(User user);
    String findLoggedInUsername();
}
