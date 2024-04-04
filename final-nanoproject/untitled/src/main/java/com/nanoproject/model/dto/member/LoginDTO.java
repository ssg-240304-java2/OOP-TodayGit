package com.nanoproject.model.dto.member;

public class LoginDTO {
    public String name; // 사용자 이름
    private String secretNum; // 비밀번호
    private String phoneNum; //핸드폰번호

    public String getName() {
        return name;
    }

    public String getSecretNum() {
        return secretNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public LoginDTO() {
    }

    public LoginDTO(String name, String secreteNum, String phoneNum) {
        this.name = name;
        this.secretNum = secreteNum;
        this.phoneNum = phoneNum;
    }
}
