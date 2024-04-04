package com.nanoproject.run;

import com.nanoproject.controller.JoinMembership;
import com.nanoproject.model.dto.member.MemberDTO;
import com.nanoproject.view.LoginMenu;
import com.nanoproject.view.Menu;


public class Application {
    public static void main(String[] args) {
        JoinMembership joinMembership = new JoinMembership();
        MemberDTO memberDTO = new MemberDTO();
        while (true) {
            LoginMenu loginMenu = new LoginMenu(joinMembership);
            memberDTO = loginMenu.menu();  // 로그인창
            if(loginMenu.getNum() == 1){
                break;
            }
            new Menu(memberDTO).run(); // 구매창
        }
    }
}
