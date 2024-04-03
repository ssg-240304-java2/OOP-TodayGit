package com.nanoproject.product2.model.dto;

public class DessertDTO extends ItemDTO {
    private boolean isHeat;

    public DessertDTO(String name, int price) {
        super(name, price);
    }

    public DessertDTO(String name, int price, boolean isHeat) {
        super(name, price);
        this.isHeat = isHeat;
    }

    @Override
    public String toString() {
        return super.toString() + " 오븐 토스팅 " + (isHeat ? "O" : "X");
    }
}
