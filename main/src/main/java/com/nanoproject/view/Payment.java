package com.nanoproject.view;

import com.nanoproject.model.dto.member.MemberDTO;

public class Payment {
    public void run(MemberDTO member, int totalPrice) {
        System.out.println(member.getNickName()+ " 님의 총 결제 금액은 " + totalPrice + " 원 입니다.\n결제를 완료했습니다.");
    }
}
