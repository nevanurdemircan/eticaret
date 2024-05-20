package org.example.service;

import org.example.dto.UserDto;
import org.example.entity.User;
import org.example.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    private UserRepository userRepository = UserRepository.getInstance();
    private static UserService userService;
    public static UserService getInstance(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }

    public User save(UserDto userDto){
        User user = new User();
        user.setUsername(userDto.username());
        user.setBalance(userDto.balance());

        return userRepository.save(user);
    }
    public static void updateBalance(Connection connection, int userId, double totalPrice) throws SQLException {
        String sql = "UPDATE users SET balance = balance - ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, totalPrice);
            statement.setInt(2, userId);
            statement.executeUpdate();
        }
    }

    public User getUserById(int userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = ConnectionProvider.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getInt("id"));
                    user.setUsername(resultSet.getString("username"));
                    user.setBalance(resultSet.getDouble("balance"));
                    return user;
                }
            }
        }
        return null;
    }
}
