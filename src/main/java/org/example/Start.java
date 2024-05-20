package org.example;

import org.example.service.UIService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Start {
    public static void start(Connection connection , UIService uiService) throws SQLException{
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("1. Ürün Ekle");
            System.out.println("2. Kullanıcı Ekle");
            System.out.println("3. Satıcı Ekle");
            System.out.println("4. Sepete Ürün Ekle");
            System.out.println("5. Sepeti Görüntüle");
            System.out.println("6. Ürün satın al");
            System.out.println("7. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    uiService.addProduct();
                    break;
                case 2:
                    uiService.addUser();
                    break;
                case 3:
                    uiService.addSeller();
                    break;
                case 4:
                    uiService.addToCart(connection);
                    break;
                case 5:
                    System.out.print("Kullanıcı ID'sini girin: ");
                    int userId = scanner.nextInt();
                    uiService.viewCart(connection, userId);
                    break;
                case 6:
                    System.out.print("Kullanıcı ID'sini girin: ");
                    int userIdForBuy = scanner.nextInt();
                    System.out.print("Ürün ID'sini girin: ");
                    int productIdForBuy = scanner.nextInt();
                    uiService.buy(connection, userIdForBuy, productIdForBuy);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Geçersiz seçenek! Lütfen tekrar deneyin.");
            }
        }
    }
}
