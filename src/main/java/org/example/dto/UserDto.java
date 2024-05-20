package org.example.dto;

public class UserDto {
    private int id;
    private String username;
    private double balance;

    public UserDto() {
    }

    public UserDto(int id, String username, double balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double balance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
