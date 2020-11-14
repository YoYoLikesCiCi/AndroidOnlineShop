package com.example.onlineshop_v2.ui.labelbook;



//新建一个商品实体类，包含参数  书名，图片的id
public class Book {
    private String name;
    private int imageid;

    public Book(String name,int imageid){
        this.name = name;
        this.imageid = imageid;
    }

    public int getImageid() {
        return imageid;
    }

    public String getName() {
        return name;
    }
}
