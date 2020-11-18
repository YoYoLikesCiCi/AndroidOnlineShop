package com.example.onlineshop_v2.ui.specialfunctions;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.Serializable;
import java.net.URL;

public class GoodsEntity  implements Serializable {
    public String imgPath;
    public String goodsName;
    public String goodPrice;

    public GoodsEntity(){

    }

    public GoodsEntity(String imgPath, String goodName, String goodPrice){
        this.imgPath = imgPath;
        this.goodsName = goodsName;
        this.goodPrice = goodPrice;
    }

    public String getImgPath(){
        return imgPath;
    }

    public void setImgPath(String imaPath){
        this.imgPath = imgPath;
    }

    public String getGoodsName(){
        return goodsName;
    }

    public void setGoodsName(String goodsName){
        this.goodsName = goodsName;
    }

    public String getGoodPrice(){
        return goodPrice;
    }
    public void setGoodPrice(String goodPrice){
        this.goodPrice = goodPrice;
    }

    @Override
    public String toString(){
        return "GoodsEntity{" +
                "imgPath = '" + imgPath + '\'' +
                ",goodsName = '" + goodsName + '\''+
                ", goodsPrice = " + goodPrice + '\'' +
                '}' ;
    }

//    String url = "http://47.93.25.50/static/9787020015092.jpg";
//    URL req = new URL(url);
//    Bitmap mIcon_cat = BitmapFactory.decodeStream(req.openConnection().getInputStream());

}
