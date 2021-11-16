package com.example.cakeshopip;

public class Cake {
    private String name;
    private String image;
    private String price;

    private String detail;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }


    public  Cake(){}

    public Cake(String name, String image, String price) {
        this.name = name;
        this.image = image;
        this.price = price;
    }
    public Cake(String name, String image, String price,String detail) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.detail=detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
