package com.nanoproject.view;

import com.nanoproject.controller.MemberController;
import com.nanoproject.model.dto.member.LoginStatus;
import com.nanoproject.model.dto.member.MemberDTO;

import java.util.Scanner;

public class LoginMenu {
    //private JoinMembership joinMembership = new JoinMembership();
    private MemberController memberController;
    private MemberDTO member = new MemberDTO();
    private int num;

    public LoginMenu(MemberController memberController) {
        this.memberController = memberController;
    }

    public MemberDTO menu(){
        //call call1 = new call();
        Scanner sc = new Scanner(System.in);

        label :
        while(true) {
            System.out.println("""
                    ========================================
                    안녕하세요 스타벅스입니다.
                    회원가입을 원하시면 1번을 입력하시고
                    로그인을 원하시면 2번을 입력하시고
                    종료를 원하시면 9번을 입력해주세요.
                    ========================================
                    """);
            System.out.print("숫자를 입력해주세요 : ");
            int select = sc.nextInt();
            sc.nextLine();
            if (select == 1) {
                System.out.println("""
                        ========================================
                        회 원 가 입
                        ========================================
                        """);
                while (!isMemAdded()) System.out.println("이미 존재하는 ID입니다. 다른 ID를 입력해주세요.");
            } else if (select == 2) {
                this.member = searchID();
                break;
            }else if(select == 9){
                System.out.println("프로그램을 종료합니다.");
                num = 1;
                break;
            } else {
                System.out.println("숫자를 잘못 입력하셨습니다. 1번과 2번중 다시 입력해 주세요.");
                continue label;
            }
        }
        return this.member;
    }

    public int getNum() {
        return num;
    }
    /***
     * 회원으로 가입하기
     */

    /**
     * 회원 정보를 입력받고 계정이 중복되었는지 검사
     * @return ID가 중복되지 않아서 회원가입을 성공했으면 true, ID가 중복이면 false 반환
     */
    private boolean isMemAdded() {
        Scanner sc = new Scanner(System.in);
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("비밀번호 : ");
        String secretNum = sc.nextLine();
        System.out.print("핸드폰번호 : ");
        String phoneNum = sc.nextLine();
        System.out.print("ID : ");
        String id = sc.nextLine();
        System.out.print("닉네임 : ");
        String nickName = sc.nextLine();
        if (!memberController.isValidID(id)) return false;
        MemberDTO member = new MemberDTO(name,secretNum,phoneNum,id,nickName);
        this.memberController.addMember(member);
        return true;
    }

    /***
     * 로그인시 회원 정보 찾기
     */
    public MemberDTO searchID(){
        Scanner sc = new Scanner(System.in);
        MemberDTO member = null;
        while (true) {
            System.out.print("아이디 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호 : ");
            String SecreteNum = sc.nextLine();
            LoginStatus loginStatus = memberController.tryLogin(id,SecreteNum);
            if (loginStatus == LoginStatus.ID_NOT_FOUND) System.out.println("회원 정보를 찾을 수 없습니다. 다시 시도하세요.");
            if (loginStatus == LoginStatus.WRONG_PASSWORD) System.out.println("비밀번호가 틀렸습니다 다시 시도하세요..");
            if (loginStatus == LoginStatus.SUCCESS) {
                member = memberController.getMemberById(id);
                System.out.println("로그인 되었습니다.");
                System.out.println(member.getNickName() + " 님 환영합니다.");
                break;
            }
        }
        return member;
    }
}
