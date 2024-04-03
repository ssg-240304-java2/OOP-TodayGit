package com.nanoproject.product.run;

import com.nanoproject.product.model.dto.MemberDTO;
import com.nanoproject.product.view.Menu;


public class Application {
    public static void main(String[] args) {
        new Menu(new MemberDTO()).run();
    }
}
