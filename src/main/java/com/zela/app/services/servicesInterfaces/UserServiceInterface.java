package com.zela.app.services.servicesInterfaces;

import java.util.List;

import com.zela.app.models.User;

public interface UserServiceInterface {
    User save(User user);

    User findById(int id);

    User update(User user);

    boolean deleteById(int id);

    List<User> allUser();
}
