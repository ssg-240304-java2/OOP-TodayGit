package com.nanoproject.model.dto.member;

public class MemberDTO extends LoginDTO {
    private String identification; // ID
    private String nickName;  // 닉네임

    public String getIdentification() {
        return identification;
    }

    public String getNickName() {
        return nickName;
    }

    public MemberDTO() {
    }

    public MemberDTO(String name, String secretNum, String phoneNum, String identification, String nickName) {
        super(name, secretNum, phoneNum);
        this.identification = identification;
        this.nickName = nickName;
    }

}
