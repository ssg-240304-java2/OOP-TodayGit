package com.nanoproject.product2.run;

import com.nanoproject.login.dto.Member;
import com.nanoproject.login.view.LoginMenu;
import com.nanoproject.product2.model.dto.MemberDTO;
import com.nanoproject.product2.view.Menu;


public class Application {
    public static void main(String[] args) {
        LoginMenu loginMenu = new LoginMenu();
        new Menu(loginMenu.menu()).run();
    }
}
