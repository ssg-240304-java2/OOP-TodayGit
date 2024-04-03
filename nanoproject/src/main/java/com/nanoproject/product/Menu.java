package com.nanoproject.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Menu {
//    private MenuManager menuMager;
    ArrayList<Item> menus = new ArrayList<Item>();

    /***
     * 고정된 메뉴 배열 생성
     */
    public Menu() {
        Item menu1 = new Beverage("아메리카노", 5000);
        Item menu2 = new Beverage("카페라떼", 5500);
        Item menu3 = new Beverage("카푸치노", 6000);
        Item menu4 = new Dessert("허니브레드", 5500);
        Item menu5 = new Dessert("도넛", 3000);
        Item menu6 = new Dessert("고로케", 2500);

        menus.add(menu1);
        menus.add(menu2);
        menus.add(menu3);
        menus.add(menu4);
        menus.add(menu5);
        menus.add(menu6);
    }
//    public Menu(Member member) {
//    }


    /***
     * 메뉴 출력
     */
    public void showMenu() {
        System.out.println("""
                =============== todayGit cafe ===============""");
        int count = 0;

        for (Item item : menus) {
            count++;
            System.out.print(count + "번...메뉴 이름: " + item.getName());
            System.out.print(", 가격: " + item.getPrice());
            System.out.println();
        }
    }
}
