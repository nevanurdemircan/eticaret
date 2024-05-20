package org.example.repository;

import org.example.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository implements BaseRepository<User, Integer> {
    private static UserRepository userRepository;
    public static UserRepository getInstance(){
        if(userRepository == null){
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public User findById(Integer integer) {
        return null;
    }

    public static void addUser(Connection connection, User user) throws SQLException {
        String sql = "INSERT INTO users (username, balance) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setDouble(2, user.getBalance());
            statement.executeUpdate();
        }
    }
}
