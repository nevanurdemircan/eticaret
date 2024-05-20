package org.example.entity;

public class Seller extends BaseEntity {
    private int id;
    private String sellerName;

    public Seller(int id, String salesPersonName) {
        this.id = id;
        this.sellerName = salesPersonName;
    }

    public Seller() {
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String sellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
