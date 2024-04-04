package com.nanoproject.run;

import com.nanoproject.controller.MemberController;
import com.nanoproject.model.dto.member.MemberDTO;
import com.nanoproject.view.LoginMenu;
import com.nanoproject.view.Menu;


public class Application {
    public static void main(String[] args) {
        MemberController memberController = new MemberController();
        MemberDTO memberDTO = new MemberDTO();
        while (true) {
            LoginMenu loginMenu = new LoginMenu(memberController);
            memberDTO = loginMenu.menu();  // 로그인창
            if(loginMenu.getNum() == 1){
                break;
            }
            new Menu(memberDTO).run(); // 구매창
        }
    }
}
