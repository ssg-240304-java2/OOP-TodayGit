package com.nanoproject.login.controller;

import com.nanoproject.login.db.MemberDB;
import com.nanoproject.login.dto.LoginStatus;
import com.nanoproject.login.dto.Member;

import java.util.ArrayList;



public class JoinMembership {
    private MemberDB memberDB = new MemberDB();
    /***
     * 회원가입용 회원 추가
     * @param member
     */
    public void addMember(Member member){
        memberDB.addMember(member);
    }

    public LoginStatus tryLogin(String id, String secreteNum){
        return memberDB.getLoginStatus(id, secreteNum);
    }

    /**
     * @param id:  id를 인자로 받아서 member
     * @return: id가 중복되면 false, 유효한 id면 true 반환
     */
    public boolean isValidID(String id) {
        ArrayList<Member> members = memberDB.getMembers();
        for (Member member : members) {
            if (member.getIdentification().equals(id)) return false;
        }
        return true;
    }

    public Member getMemberById(String id) {
        return memberDB.getMemberById(id);
    }
}
