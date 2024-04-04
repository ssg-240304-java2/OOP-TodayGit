package com.nanoproject.model.dto.member;

public class LoginDTO {
    public String name; // 사용자 이름
    private String secreteNum; // 비밀번호
    private String phoneNum; //핸드폰번호

    public String getName() {
        return name;
    }

    public String getSecreteNum() {
        return secreteNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public LoginDTO() {
    }

    public LoginDTO(String name, String secreteNum, String phoneNum) {
        this.name = name;
        this.secreteNum = secreteNum;
        this.phoneNum = phoneNum;
    }
}
