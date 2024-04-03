package com.nanoproject.product2.view;

import com.nanoproject.login.dto.Member;

public class Payment {
    public void run(Member member, int totalPrice) {
        System.out.println("총 결제 금액은 " + totalPrice + " 원 입니다.\n 결제를 완료했습니다.");
    }
}
