package com.nanoproject.login.dto;

public class Member extends Login{
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

    public Member(String name/*, LocalDate birth*/, String secreteNum, String phoneNum, String identification, String nickName) {
        super(name/*, birth*/, secreteNum, phoneNum);
        this.identification = identification;
        this.nickName = nickName;
    }

}
