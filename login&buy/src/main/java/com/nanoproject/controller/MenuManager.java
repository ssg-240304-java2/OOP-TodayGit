package com.nanoproject.product2.controller;


import com.nanoproject.product2.model.dto.ItemDTO;
import com.nanoproject.product2.model.entity.Order;

import java.util.List;

public class MenuManager {
    private Order order;

    public MenuManager() {
        order = new Order();
    }

    public void addItem(ItemDTO item) {
        order.addItem(item);
        System.out.printf("%s가 장바구니에 담겼습니다.\n", item.getName());
    }

    public void deleteItem(int itemNo) {
        if (itemNo < 0) return;
        String itemName = order.getItemByItemNo(itemNo).getName();
        order.deleteItem(itemNo);
        System.out.printf("%s가 장바구니에서 삭제되었습니다.\n", itemName);
    }

    public void clearBasket() {
        order.clearList();
        System.out.println("장바구니를 비웠습니다.");
    }

    public boolean showBasket() {
        List<ItemDTO> itemList = order.getItemList();
        if (itemList.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
            return false;
        }
        else {
            System.out.println("===== 담은 내역 =====");
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println((i + 1) + ". " + itemList.get(i));
            }
            System.out.println();
            System.out.println("총 금액 : " + getTotalPrice());
            return true;
        }
    }

    public int getTotalPrice() {
        List<ItemDTO> itemList = order.getItemList();
        int totalPrice = 0;
        for (ItemDTO itemDTO : itemList) {
            totalPrice += itemDTO.getPrice();
        }
        return totalPrice;
    }

    public int getItemCount() {
        return order.getItemList().size();
    }

    public boolean isPayable() {
        if (getTotalPrice() == 0) {
            System.out.println("결제할 상품이 없습니다.");
            return false;
        } else {
            return true;
        }
    }
}
