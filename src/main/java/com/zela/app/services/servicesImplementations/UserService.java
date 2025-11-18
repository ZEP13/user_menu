package com.zela.app.services.servicesImplementations;

import com.zela.app.repositories.JdbcImplementation.JdbcUserRepository;
import com.zela.app.services.servicesInterfaces.UserServiceInterface;

public class UserService implements UserServiceInterface {

    private final JdbcUserRepository repository;

    public UserService(JdbcUserRepository repository) {
        this.repository = repository;
    }

}
