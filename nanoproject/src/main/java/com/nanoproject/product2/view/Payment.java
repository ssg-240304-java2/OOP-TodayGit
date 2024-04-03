package com.nanoproject.product2.view;

import com.nanoproject.product2.model.dto.MemberDTO;

public class Payment {
    public void run(MemberDTO member, int totalPrice) {
        System.out.println("Payment.run with " + totalPrice);
    }
}
