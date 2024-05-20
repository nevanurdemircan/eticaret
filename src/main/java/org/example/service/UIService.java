package org.example.service;

import org.example.dto.ProductDto;
import org.example.dto.SellerDto;
import org.example.dto.UserDto;
import org.example.entity.Product;
import org.example.entity.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import static org.example.repository.ProductRepository.calculateTotalPrice;
import static org.example.service.UserService.updateBalance;

public class UIService {
    private Logger log = Logger.getLogger(getClass().getSimpleName());
    private Scanner scanner = new Scanner(System.in);
    private ProductService productService = ProductService.getInstance();
    private UserService userService = UserService.getInstance();
    private SellerService sellerService = SellerService.getInstance();
    public void addProduct() {
        log.info("Ürün adını girin:");
        String productName = scanner.nextLine();
        log.info("Ürün fiyatını girin:");
        double price = scanner.nextDouble();

        ProductDto productDto = new ProductDto();
        productDto.setName(productName);
        productDto.setPrice(price);

        productService.save(productDto);
        log.info("yeni ürün eklendi");
    }

    public void addUser() {
        log.info("İsminizi girin:");
        String username = scanner.nextLine();
        log.info("Bakiyenizi girin:");
        double balance = scanner.nextDouble();

        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setBalance(balance);

        userService.save(userDto);
        log.info("yeni kullanıcı eklendi.");
    }

    public void addSeller() {
        log.info("İsminizi girin:");
        String username = scanner.nextLine();
        SellerDto sellerDto = new SellerDto();
        sellerDto.setSellerName(username);

        sellerService.save(sellerDto);
        log.info("yeni satıcı başarıyla kaydedildi");

    }

    public void addToCart(Connection connection) throws SQLException {
        log.info("Ürün ID'sini girin:");
        int userId = scanner.nextInt();
        log.info("Kullanıcı ID'sini girin:");
        int productId = scanner.nextInt();
        scanner.nextLine();
        CartService.addToCart(connection, userId, productId);
        log.info("Ürün sepete eklendi");
    }

    public void viewCart(Connection connection, int userId) throws SQLException {
        List<Product> cartItems = CartService.viewCart(connection, userId);
        if (cartItems.isEmpty()) {
            System.out.println("Sepetinizde hiç ürün bulunmamaktadır.");
        } else {
            System.out.println("Sepetinizdeki ürünler:");
            for (Product product : cartItems) {
                System.out.println(product);
            }
        }
        System.out.println("Sepet görüntülendi");
    }

    public void buy(Connection connection, int userId, int productId) throws SQLException {
        List<Product> cartItems = CartService.viewCart(connection, userId);
        if (cartItems.isEmpty()) {
            System.out.println("Sepetinizde hiç ürün bulunmamaktadır.");
            return;
        }
        double totalPrice = calculateTotalPrice(cartItems);

        User user = userService.getUserById(userId);
        if (user == null) {
            System.out.println("Kullanıcı bulunamadı.");
            return;
        }
        if (totalPrice > user.getBalance()) {
            System.out.println("Yetersiz bakiye. Lütfen bakiyenizi yükleyin.");
            return;
        }
        updateBalance(connection, userId, totalPrice);
        System.out.println("Satın alma işlemi başarıyla gerçekleştirildi. Kalan bakiye: " + (user.getBalance() - totalPrice));
    }
}

