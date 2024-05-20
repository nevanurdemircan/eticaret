package org.example.repository;

import org.example.entity.Seller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SellerRepository implements BaseRepository<Seller, Integer> {

    private static SellerRepository sellerRepository;

    public static SellerRepository getInstance() {
        if (sellerRepository == null) {
            sellerRepository = new SellerRepository();
        }
        return sellerRepository;
    }

    @Override
    public Seller save(Seller entity) {
        return null;
    }

    @Override
    public Seller findById(Integer integer) {
        return null;
    }

    public static void addSeller(Connection connection, String sellerName) throws SQLException {
        String sql = "INSERT INTO Seller (seller_name) VALUES(?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, sellerName);
            statement.executeUpdate();
        }
    }
}
