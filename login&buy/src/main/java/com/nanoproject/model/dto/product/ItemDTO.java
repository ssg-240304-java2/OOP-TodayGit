package com.nanoproject.product2.model.dto;

public class ItemDTO {
    String name;
    int price;

    public ItemDTO(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s %d원", name, price);
    }
}
