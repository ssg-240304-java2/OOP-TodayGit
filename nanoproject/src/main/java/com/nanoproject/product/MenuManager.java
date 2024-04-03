package com.nanoproject.product;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager {
    private Menu menu;
    private Scanner sc;

    /***
     *선택한 item 객체를 담을 배열, status을 순차적으로 담기 위한 배열 생성
     */
    ArrayList<Item> cart = new ArrayList<>();
    ArrayList<String> opt = new ArrayList<>();

    public MenuManager() {
        sc = new Scanner(System.in);
        menu = new Menu();
    }

    public void order() {
        int max = 10;
        String[] status = new String[max];
        String command;
        int count = 0;
        do {
            System.out.println("""
                    =============== 주문하시겠습니까? ===============
                    ========주문하실 메뉴 번호를 입력해주세요========""");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("========아메리카노를 골랐습니다.========");
                    break;
                case 2:
                    System.out.println("========카페라떼를 골랐습니다.========");
                    break;
                case 3:
                    System.out.println("========카푸치노를 골랐습니다.========");
                    break;
                case 4:
                    System.out.println("========허니브레드를 골랐습니다.========");
                    break;
                case 5:
                    System.out.println("========도넛을 골랐습니다.========");
                    break;
                case 6:
                    System.out.println("========고로케를 골랐습니다.========");
                    break;
                default:
                    System.out.println("========번호를 잘못 입력하셨습니다.========");
            }
            System.out.print("===차갑게 드시겠습니까? 따뜻하게 드시겠습니까? ice 혹은 hot을 입력해주세요 : ");
            while (true) {
                status[count] = sc.next();
                if (status[count].equals("ice") || status[count].equals("hot")) {
                    System.out.println("=====" + status[count] + " 선택하셨습니다.======");
                    opt.add(status[count]);
                    count++;
                    break;
                } else {
                    System.out.println("=======잘못입력하셨습니다. 다시 입력해주세요=======");
                }
            }
            Item chosenItem = menu.menus.get(choice - 1);
            cart.add(chosenItem);

            System.out.println("===더 주문하시겠습니까? 원하시면 'Yes', 중단을 원할 경우 'No'를 입력해주세요 : ");
            command = sc.next();
            sc.nextLine();
        } while (!command.equalsIgnoreCase("No"));

        show();

    }

//    public void add() {
//    }

    public void clear() {
        cart.clear();
        opt.clear();
        System.out.println("=====장바구니를 초기화했습니다. 최소 한 잔 이상 주문해야 합니다.=====");
        order();
    }

//    public void delete(int i) {
//    }

    public void show() {
        String command;
        System.out.println("========장바구니에 담긴 내역========");
        for (int i = 0; i < cart.size(); i++) {
            System.out.println((i+1) + "번째 " + cart.get(i) + " [" + opt.get(i) + "]");
        }
        System.out.println("===장바구니 확정 및 구매를 원하시면 'Yes', 장바구니를 비우시려면 'No'를 입력해주세요 : ");
        do {
            command = sc.next();
            sc.nextLine();
            if(command.equalsIgnoreCase("Yes")){
                System.out.println("========장바구니에 담은 메뉴의 총액은 " + getSum() + "입니다.========");
                break;
            } else if (command.equalsIgnoreCase("No")){
                System.out.println("================장바구니를 초기화합니다================");
                clear();
            }
        } while (!command.equalsIgnoreCase("No"));
    }
    public int getSum() {
        int sum = 0;
        for (Item item : cart) {
            sum += item.getPrice();
        } return sum;
    }
}
