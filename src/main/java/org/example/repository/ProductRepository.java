package org.example.repository;

import org.example.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ProductRepository implements BaseRepository<Product, Integer> {
    private static ProductRepository productRepository;

    public static ProductRepository getInstance() {
        if (productRepository == null) {
            productRepository = new ProductRepository();
        }
        return productRepository;
    }

    @Override
    public Product save(Product entity) {
        return null;
    }

    @Override
    public Product findById(Integer integer) {
        return null;
    }

    public static double calculateTotalPrice(List<Product> products) {
        double totalPrice = 0.0;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return totalPrice;
    }

    public static void addProduct(Connection connection, String productName, double price) throws SQLException {
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, productName);
            statement.setDouble(2, price);
            statement.executeUpdate();
        }
    }
}
