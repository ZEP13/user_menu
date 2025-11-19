package com.zela.app.services.servicesImplementations;

import java.util.List;

import com.zela.app.exceptions.UserException;
import com.zela.app.models.User;
import com.zela.app.repositories.JdbcImplementation.JdbcUserRepository;
import com.zela.app.services.servicesInterfaces.UserServiceInterface;

public class UserService implements UserServiceInterface {

    private final JdbcUserRepository repository;

    public UserService(JdbcUserRepository repository) {
        this.repository = repository;
    }

    public User save(User user) {
        validateForCreate(user);
        try {
            return repository.save(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User findById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User update(User user) {
        validateForUpdate(user);
        try {
            return repository.update(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean deleteById(int id) {
        validateForDelete(id);
        try {
            return repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> allUser() {
        try {
            return repository.allUser();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void validateForCreate(User user) {
        if (user == null)
            throw new IllegalArgumentException("user is null");

        if (user.getNom() == null || user.getNom().isBlank())
            throw new UserException("titre is required");

        if (user.getPrenom() == null || user.getPrenom().isBlank())
            throw new UserException("contenu is required");
    }

    private void validateForUpdate(User a) {
        if (a == null)
            throw new IllegalArgumentException("user is null");
        if (a.getId() <= 0)
            throw new UserException("id_user is invalid");
        validateForCreate(a);
    }

    private void validateForDelete(Integer id) {
        if (id == null)
            throw new IllegalArgumentException("id is null");
        if (id <= 0)
            throw new UserException("id is invalid");
    }

}
