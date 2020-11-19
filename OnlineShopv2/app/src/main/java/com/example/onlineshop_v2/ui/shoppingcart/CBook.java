package com.example.onlineshop_v2.ui.shoppingcart;

public class CBook {
    private String name;
    private String price;
    private int imageid;

    public CBook(String name, String price, int imageid) {
        this.name = name;
        this.price = price;
        this.imageid = imageid;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getImageid() {
        return imageid;
    }
}
