package com.nanoproject.run;

import com.nanoproject.view.LoginMenu;
import com.nanoproject.view.Menu;


public class Application {
    public static void main(String[] args) {
        LoginMenu loginMenu = new LoginMenu();
        new Menu(loginMenu.menu()).run();
    }
}
