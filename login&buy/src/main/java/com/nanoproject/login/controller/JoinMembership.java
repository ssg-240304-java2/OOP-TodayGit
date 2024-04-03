package com.nanoproject.login.controller;

import com.nanoproject.login.db.MemberDB;
import com.nanoproject.login.dto.LoginStatus;
import com.nanoproject.login.dto.Member;

import java.util.ArrayList;
//import com.todaygit.minipjt.login.dto.NonMember;


public class JoinMembership {
    private MemberDB memberDB = new MemberDB();
    /***
     * 회원가입용 회원 추가
     * @param member
     */
    public void addMember(Member member){
        memberDB.addMember(member);
        // db에 멤버 추가
    }


    /*public void addNonMember(NonMember nonMember){
        // db에 비회원 추가
        memberDB.addNonMember(nonMember);
    }*/

    public LoginStatus tryLogin(String id, String secreteNum){
//        Member member = new Member();
        return memberDB.getLoginStatus(id, secreteNum);
//        return member;
        // 아이디가 일치하는 객체를 찾아 해당 인덱스를 리턴
        // 일치하는 아이디가 없는 경우 -1 리턴
        // MemberDB memberDB = new MemberDB();
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
