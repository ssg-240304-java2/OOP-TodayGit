package com.nanoproject.product.view;

import com.nanoproject.product.model.dto.MemberDTO;

public class Payment {
    public void run(MemberDTO member, int totalPrice) {
        System.out.println("Payment.run with " + totalPrice);
    }
}
