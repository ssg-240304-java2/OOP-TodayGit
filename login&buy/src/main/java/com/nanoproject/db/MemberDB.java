package com.nanoproject.db;


import com.nanoproject.model.dto.member.LoginStatus;
import com.nanoproject.model.dto.member.MemberDTO;

import java.util.ArrayList;

public class MemberDB {
    private ArrayList<MemberDTO> members = new ArrayList<>();  // 회원용 컬렉션 리스트 생성



    private int memCount;
    private int nonCount;

    public ArrayList<MemberDTO> getMembers() {
        return members;
    }

    /***
     * DB에 회원가입시 회원 정보를 담는(추가하는) 콜렉션
     * @param members
     */
    public void addMember (MemberDTO members){
        this.members.add(members);
        this.memCount++;

    }
    // 멤버를 반환
    public LoginStatus getLoginStatus(String id, String SecreteNum){
        LoginStatus loginStatus = LoginStatus.ID_NOT_FOUND;
        for (int i = 0; i < members.size(); i++) {
            if(this.members.get(i).getIdentification().equals(id)){ // 일치하는 아이디의 객체 위치를 출력
                if(this.members.get(i).getSecreteNum().equals(SecreteNum)){ // 비밀번호 일치하는지 확인
                    loginStatus = LoginStatus.SUCCESS;
                    break;
                }else{
                    loginStatus = LoginStatus.WRONG_PASSWORD;
                    break;
                }
            }else{
                loginStatus = LoginStatus.ID_NOT_FOUND;
            }
        }
        return loginStatus;
    }


    public MemberDTO getMemberById(String id) {
        MemberDTO foundMember = null;
        for (MemberDTO member : members) {
            if (member.getIdentification().equals(id)) foundMember = member;
        }
        return foundMember;
    }

}
