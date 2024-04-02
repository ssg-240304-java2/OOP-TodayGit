package com.nanoproject.section;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MembershipSystem {

    private static List<Member> members = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 종료");
            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 버퍼 비우기

            switch (choice) {
                case 1:
                    registerMember();
                    login();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("올바른 메뉴를 선택하세요.");
            }
        }
    }

    private static void registerMember() {
        System.out.println("1. 회원");
        System.out.println("2. 비회원");
        System.out.print("회원 유형을 선택하세요 (1 또는 2): ");
        int memberType = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        if (memberType == 1) {
            System.out.print("이름을 입력하세요: ");
            String name = scanner.nextLine();
            System.out.print("아이디를 입력하세요: ");
            String username = scanner.nextLine();
            System.out.print("비밀번호를 입력하세요: ");
            String password = scanner.nextLine();
            System.out.print("전화번호를 입력하세요: ");
            String phoneNumber = scanner.nextLine();

            Member member = new Member(name, username, password, phoneNumber);
            members.add(member);
            System.out.println("회원가입이 완료되었습니다.");
        } else if (memberType == 2) {
            System.out.print("이름을 입력하세요: ");
            String name = scanner.nextLine();
            System.out.print("아이디를 입력하세요: ");
            String username = scanner.nextLine();
            int randomCode = 1000 + random.nextInt(9000); // 4자리 랜덤 코드 생성
            System.out.println("랜덤 코드가 생성되었습니다: " + randomCode);

            Member member = new Member(name, username, String.valueOf(randomCode));
            members.add(member);
            System.out.println("비회원 가입이 완료되었습니다.");
        } else {
            System.out.println("올바른 회원 유형을 선택하세요.");
        }
    }

    private static void login() {
        System.out.print("아이디를 입력하세요: ");
        String username = scanner.nextLine();
        System.out.print("비밀번호를 입력하세요: ");
        String password = scanner.nextLine();

        for (Member member : members) {
            if (member.getUsername().equals(username)) {
                if (member.getPassword().equals(password)) {
                    System.out.println("로그인에 성공했습니다.");
                    return;
                } else {
                    System.out.println("비밀번호가 올바르지 않습니다.");
                    return;
                }
            }
        }

        System.out.println("해당 아이디가 존재하지 않습니다.");
    }
}