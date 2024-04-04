package com.nanoproject.model.dto.product;

public class BeverageDTO extends ItemDTO {
    private boolean isHot;

    public BeverageDTO(String name, int price) {
        super(name, price);
    }

    public BeverageDTO(String name, int price, boolean isHot) {
        super(name, price);
        this.isHot = isHot;
    }

    @Override
    public String toString() {
        return super.toString() + " " + (isHot ? "Hot" : "Ice") ;
    }
}
