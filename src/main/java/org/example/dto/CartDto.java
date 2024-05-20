package org.example.dto;

public class CartDto {
    private int id;

    public CartDto(int id) {
        this.id = id;
    }

    public CartDto() {
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
