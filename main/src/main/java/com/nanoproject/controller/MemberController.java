package com.nanoproject.controller;

import com.nanoproject.db.MemberDB;
import com.nanoproject.model.dto.member.LoginStatus;
import com.nanoproject.model.dto.member.MemberDTO;

import java.util.ArrayList;

public class MemberController {
    private MemberDB memberDB = new MemberDB();
    /***
     * 회원가입용 회원 추가
     * @param member
     */
    public void addMember(MemberDTO member){
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
        ArrayList<MemberDTO> members = memberDB.getMembers();
        for (MemberDTO member : members) {
            if (member.getIdentification().equals(id)) return false;
        }
        return true;
    }

    public MemberDTO getMemberById(String id) {
        return memberDB.getMemberById(id);
    }



}
