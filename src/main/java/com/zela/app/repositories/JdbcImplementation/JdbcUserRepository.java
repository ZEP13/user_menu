package com.zela.app.repositories.JdbcImplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zela.app.connection_db.DbConfig;
import com.zela.app.models.User;
import com.zela.app.repositories.interfaceImplementaion.UserRepository;

public class JdbcUserRepository implements UserRepository {

    private final DbConfig dbConfig;

    public JdbcUserRepository(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }

    public Connection getConnection() throws SQLException {
        return dbConfig.getConnection();

    }

    @Override
    public User save(User user) throws SQLException {
        String sql = "INSERT INTO users (nom, prenom) VALUES (?, ?)";
        try (Connection c = dbConfig.getConnection();
                PreparedStatement ps = c.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            int affected = ps.executeUpdate();

            if (affected == 0)
                throw new SQLException("echec creation user");
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    user.setId(rs.getInt(1));
                }
            }
        }
        return user;
    }

    @Override
    public User update(User user) throws SQLException {
        if (user.getId() == 0) {
            throw new SQLException("echec update car id invalide");
        }
        String sql = "UPDATE users SET nom = ?, prenom = ? WHERE id = ?";
        try (Connection c = dbConfig.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            ps.setInt(3, user.getId());
            int affected = ps.executeUpdate();

            if (affected == 0)
                throw new SQLException("erreur lors de la mise a jour de l'user");

            return user;
        }
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        String sql = "DELETE * FROM  users WHERE id = ?";
        try (Connection c = dbConfig.getConnection();
                PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            int affected = ps.executeUpdate();

            return affected > 0;
        }
    }

    @Override
    public List<User> allUser() throws SQLException {
        List<User> listuser = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection c = dbConfig.getConnection();
                PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                listuser.add(new User(rs));

            }
        }
        return listuser;
    }
}
