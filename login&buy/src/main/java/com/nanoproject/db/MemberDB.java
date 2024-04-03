package com.nanoproject.login.db;

import com.nanoproject.login.dto.LoginStatus;
import com.nanoproject.login.dto.Member;

import java.util.ArrayList;

public class MemberDB {
    private ArrayList<Member> members = new ArrayList<>();  // 회원용 컬렉션 리스트 생성

    private int memCount;
    private int nonCount;

    public ArrayList<Member> getMembers() {
        return members;
    }

    /***
     * DB에 회원가입시 회원 정보를 담는(추가하는) 콜렉션
     * @param members
     */
    public void addMember (Member members){
        this.members.add(members);
        this.memCount++;
    }
    // 멤버를 반환
    public LoginStatus getLoginStatus(String id, String SecreteNum){
        LoginStatus loginStatus = LoginStatus.ID_NOT_FOUND;
        for (int i = 0; i < memCount; i++) {
            if(this.members.get(i).getIdentification().equals(id)){ // 일치하는 아이디의 객체 위치를 출력
                if(this.members.get(i).getSecreteNum().equals(SecreteNum)){ // 비밀번호 일치하는지 확인
                    loginStatus = LoginStatus.SUCCESS;
                }else{
                    loginStatus = LoginStatus.WRONG_PASSWORD;
                }
            }else{
                loginStatus = LoginStatus.ID_NOT_FOUND;
            }
        }
        return loginStatus;
    }


    public Member getMemberById(String id) {
        Member foundMember = null;
        for (Member member : members) {
            if (member.getIdentification().equals(id)) foundMember = member;
        }
        return foundMember;
    }
}
