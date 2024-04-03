package com.nanoproject.product.model.entity;

import com.nanoproject.product.model.dto.ItemDTO;

import java.util.ArrayList;
import java.util.List;

public class Order {
    List<ItemDTO> itemList;

    public Order() {
        itemList = new ArrayList<>();
    }

    public List<ItemDTO> getItemList() {
        return itemList;
    }

    public void addItem(ItemDTO item) {
        itemList.add(item);
    }

    public void deleteItem(int itemNo) {
        itemList.remove(itemNo - 1);
    }

    public void clearList() {
        itemList.clear();
    }

    public ItemDTO getItemByItemNo(int itemNo) {
        return itemList.get(itemNo - 1);
    }
}
