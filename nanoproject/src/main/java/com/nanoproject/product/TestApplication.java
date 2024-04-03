package com.nanoproject.product;

public class TestApplication {
    public static void main(String[] args) {

        Menu menus = new Menu();
        menus.showMenu();

        MenuManager menuManager = new MenuManager();
        menuManager.order();
    }
}
