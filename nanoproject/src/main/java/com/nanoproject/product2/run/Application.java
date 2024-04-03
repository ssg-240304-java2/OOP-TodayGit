package com.nanoproject.product2.run;

import com.nanoproject.product2.model.dto.MemberDTO;
import com.nanoproject.product2.view.Menu;


public class Application {
    public static void main(String[] args) {
        new Menu(new MemberDTO()).run();
    }
}
