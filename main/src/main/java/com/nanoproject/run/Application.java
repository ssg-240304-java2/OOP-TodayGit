package com.nanoproject.run;

import com.nanoproject.model.dto.member.MemberDTO;
import com.nanoproject.view.Login;
import com.nanoproject.view.Menu;


public class Application {
    public static void main(String[] args) {
        Login loginMenu = new Login();
        MemberDTO member = loginMenu.menu();
        new Menu(member).run();
    }
}
