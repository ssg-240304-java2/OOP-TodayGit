package com.nanoproject.model.dto.member;

import com.nanoproject.model.dto.member.Login;

public class Member extends Login {
    private String identification; // ID
    private String nickName;  // 닉네임

    public String getIdentification() {
        return identification;
    }

    public String getNickName() {
        return nickName;
    }

    public Member() {
    }

    public Member(String name, String secreteNum, String phoneNum, String identification, String nickName) {
        super(name, secreteNum, phoneNum);
        this.identification = identification;
        this.nickName = nickName;
    }

}
