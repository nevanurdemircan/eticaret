package org.example.dto;

public class SellerDto {
    private int id;
    private String sellerName;

    public SellerDto(int id, String sellerName) {
        this.id = id;
        this.sellerName = sellerName;
    }

    public SellerDto() {
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
