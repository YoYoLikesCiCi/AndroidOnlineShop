package com.example.onlineshop_v2.ui.labelbook;



//新建一个商品实体类，包含参数  书名，图片的id
public class Book {
    private String name;
    private int imageid;
    private String price;
    private String author;
    private String type;
    private String publisher;
    private String introduction;
    private String  isbn;


    public Book(String name,int imageid,String price,String author,String type,String publisher,String introduction,String  isbn){
        this.name = name;
        this.imageid = imageid;
        this.price = price;
        this.author = author;
        this.type = type;
        this.publisher = publisher;
        this.introduction = introduction;
        this.isbn = isbn;
    }

    public int getImageid() {
        return imageid;
    }

    public String getName() {
        return name;
    }

    public String getPrice(){return price;}

    public String getAuthor(){return author;}

    public String getType(){return type;}

    public String getPublisher(){return publisher;}

    public String getIntroduction(){return introduction;}

    public String  getIsbn() {
        return isbn;
    }

}
