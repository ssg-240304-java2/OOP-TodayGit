package com.nanoproject.login.view;

import com.nanoproject.login.controller.JoinMembership;
import com.nanoproject.login.dto.LoginStatus;
import com.nanoproject.login.dto.Member;

import java.util.Scanner;

public class LoginMenu {
    private JoinMembership joinMembership = new JoinMembership();
    private Member member = new Member();
    //private NonMember nonMember = new NonMember();
    public Member menu(){
        Scanner sc = new Scanner(System.in);

        label :
        // 초기화면 창
        while(true) {
            System.out.println("""
                    ========================================
                    안녕하세요 스타벅스입니다.
                    회원가입을 원하시면 1번을 입력하시고
                    로그인을 원하시면 2번을 입력하시고
                    종료를 원하시면 9번을 입력해주세요.
                    ========================================
                    """);
            // do - while로 다시 묶어서 반복 처리를 할 것인지
            System.out.print("숫자를 입력해주세요 : ");
            int select = sc.nextInt();      // 회원 비회원을 선택하기 위한 변수
            sc.nextLine();
            if (select == 1) {
                /*System.out.println("""
                        =====================================
                        회원으로 가입을 원하시면 1번을 입력해 주세요.
                        =====================================
                        """);*/
//                System.out.print("숫자를 입력해주세요 : ");
//                int mem_nonmem = sc.nextInt();
                int mem_nonmem = 1;
                if (mem_nonmem == 1) {
                    // 여기에서는 회원가입 호출
                    System.out.println("""
                            ========================================
                            회 원 가 입
                            ========================================
                            """);
                    while (!isMemAdded()) System.out.println("이미 존재하는 ID입니다. 다른 ID를 입력해주세요.");
//                    addmem();
                }else if(select == 9){
                    break;
                }else{
                    System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력해 주세요.");
                    continue label;
                }
            } else if (select == 2) {
                // 여기에서는 로그인 호출
                this.member = searchID();
                break;
            } else {
                System.out.println("숫자를 잘못 입력하셨습니다. 1번과 2번중 다시 입력해 주세요.");
                continue label;
            }
        }
        return this.member;
    }

    /***
     * 회원으로 가입하기
     */

    /*public void addmem(){
        Member member = new Member();
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("비밀번호 : ");
        String secreteNum = sc.nextLine();
        System.out.print("핸드폰번호 : ");
        String phonenum = sc.nextLine();
        System.out.print("ID : ");
        String id = sc.nextLine();
        System.out.print("닉네임 : ");
        String nickName = sc.nextLine();
        member = new Member(name,secreteNum,phonenum,id,nickName);
        //JoinMembership joinMembership = new JoinMembership();
        this.joinMembership.addMember(member);
    }*/

    /**
     * 회원 정보를 입력받고 계정이 중복되었는지 검사
     * @return ID가 중복되지 않아서 회원가입을 성공했으면 true, ID가 중복이면 false 반환
     */
    private boolean isMemAdded() {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("비밀번호 : ");
        String secreteNum = sc.nextLine();
        System.out.print("핸드폰번호 : ");
        String phonenum = sc.nextLine();
        System.out.print("ID : ");
        String id = sc.nextLine();
        System.out.print("닉네임 : ");
        String nickName = sc.nextLine();
        if (!joinMembership.isValidID(id)) return false;
        Member member = new Member(name,secreteNum,phonenum,id,nickName);
        this.joinMembership.addMember(member);
        return true;
    }

    /***
     * 로그인시 회원 정보 찾기
     */
    public Member searchID(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("아이디 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호 : ");
            String SecreteNum = sc.nextLine();
            Member member = null;
            LoginStatus loginStatus = joinMembership.tryLogin(id,SecreteNum);
            if (loginStatus == LoginStatus.ID_NOT_FOUND) System.out.println("회원 정보를 찾을 수 없습니다. 다시 시도하세요.");
            if (loginStatus == LoginStatus.WRONG_PASSWORD) System.out.println("비밀번호가 틀렸습니다 다시 시도하세요..");
            if (loginStatus == LoginStatus.SUCCESS) {
                member = joinMembership.getMemberById(id);
                System.out.println("로그인 되었습니다.");
                System.out.println(member.getNickName() + " 님 환영합니다.");
                break;
            }
        }
        return member;
    }
}
