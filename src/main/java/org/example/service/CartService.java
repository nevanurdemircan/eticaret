package org.example.service;

import org.example.dto.CartDto;
import org.example.entity.Cart;
import org.example.entity.Product;
import org.example.repository.CartRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartService {

    private CartRepository cartRepository = CartRepository.getInstance();
    private static CartService cartService;
    public static CartService getInstance(){
        if(cartService == null){
            cartService = new CartService();
        }
        return cartService;
    }

    public Cart save(CartDto cartDto){
        Cart cart = new Cart();
        cart.setId(cartDto.id());

        return cartRepository.save(cart);
    }

    public static void addToCart(Connection connection, int userId, int productId) throws SQLException {
        String sql = "INSERT INTO cart (user_id, product_id) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.setInt(2, productId);
            statement.executeUpdate();
        }
    }
    public static List<Product> viewCart(Connection connection, int userId) throws SQLException {
        List<Product> cartItems = new ArrayList<>();
        String sql = "SELECT products.* FROM products " +
                "JOIN cart ON products.id = cart.product_id " +
                "WHERE cart.user_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int productId = resultSet.getInt("id");
                    String productName = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    cartItems.add(new Product(productName, price));
                }
            }
        }
        return cartItems;
    }
}
