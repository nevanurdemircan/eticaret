package org.example.entity;

public class Cart extends BaseEntity{
    private int id;

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart() {
    }

    public Cart(int id) {
        this.id = id;
    }
}
