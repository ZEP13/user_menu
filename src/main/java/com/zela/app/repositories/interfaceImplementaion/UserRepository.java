package com.zela.app.repositories.interfaceImplementaion;

import java.util.List;

import com.zela.app.models.User;

public interface UserRepository {

    User save(User user) throws Exception;

    User update(User user) throws Exception;

    boolean deleteById(int id) throws Exception;

    List<User> allUser() throws Exception;

}
