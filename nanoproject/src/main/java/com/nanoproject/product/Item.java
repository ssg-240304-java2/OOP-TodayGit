package com.nanoproject.product;

public class Item {
    private String name;
    public int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "선택한 메뉴는 " + name +
                ", 가격은 " + price +
                "원입니다.";
    }
}
