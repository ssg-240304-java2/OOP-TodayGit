package com.nanoproject.product2.view;

import com.nanoproject.login.dto.Member;
// import com.nanoproject.product2.model.dto.MemberDTO;

public class Payment {
    public void run(Member member, int totalPrice) {
        System.out.println("Payment.run with " + totalPrice);
    }
}
