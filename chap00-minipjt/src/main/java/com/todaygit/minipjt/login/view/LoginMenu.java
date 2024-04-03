package com.todaygit.minipjt.login.view;

import com.todaygit.minipjt.login.controller.JoinMembership;
import com.todaygit.minipjt.login.db.MemberDB;
import com.todaygit.minipjt.login.dto.Member;
//import com.todaygit.minipjt.login.dto.NonMember;

import java.time.LocalDate;
import java.util.Scanner;

public class LoginMenu {
    private JoinMembership joinMembership = new JoinMembership();
    private Member member = new Member();
    //private NonMember nonMember = new NonMember();
    public void menu(){
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
                System.out.println("""
                        =====================================
                        회원으로 가입을 원하시면 1번을 입력해 주세요.
                        =====================================
                        """);
                System.out.print("숫자를 입력해주세요 : ");
                int mem_nonmem = sc.nextInt();
                if (mem_nonmem == 1) {
                    // 여기에서는 회원가입 호출
                    System.out.println("""
                            ========================================
                            회 원 가 입
                            ========================================
                            """);
                    addmem();
                } /*else if (mem_nonmem == 2) {
                    System.out.println("""
                            ========================================
                            비 회 원 가 입
                            ========================================
                            """);

                }*/else if(select == 9){
                    break;
                }else {
                    System.out.println("잘못된 숫자를 입력하셨습니다. 다시 입력해 주세요.");
                    continue label;
                }


            } else if (select == 2) {
                // 여기에서는 로그인 호출
                searchID();
            } else {
                System.out.println("숫자를 잘못 입력하셨습니다. 1번과 2번중 다시 입력해 주세요.");
                continue label;
            }
        }
    }

    /***
     * 회원으로 가입하기
     */

    public void addmem(){
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
        this.member = new Member(name,secreteNum,phonenum,id,nickName);
        //JoinMembership joinMembership = new JoinMembership();
        this.joinMembership.addMember(member);
    }



    /***
     * 로그인시 회원 정보 찾기
     */
    public void searchID(){
        Scanner sc = new Scanner(System.in);
        System.out.print("아이디 : ");
        String id = sc.nextLine();
        System.out.print("비밀번호 : ");
        String SecreteNum = sc.nextLine();
        int correct = this.joinMembership.searchMember(id, SecreteNum);
        if(correct >= 0){
            // 회원님 환영합니다.
            System.out.println("로그인 되었습니다.");
            System.out.println(correct);
            // 해당 위치에서 구매로 넘기기
        }else if(correct == -1){
            System.out.println("회원 정보가 없습니다.");
            //System.out.println(correct);
        }else{
            System.out.println("비밀번호를 잘못 입력했습니다.");
            //System.out.println(correct);
        }
    }
}
