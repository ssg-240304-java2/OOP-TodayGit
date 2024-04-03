package com.nanoproject.product2.view;


import com.nanoproject.product2.controller.MenuManager;
import com.nanoproject.product2.model.dto.BeverageDTO;
import com.nanoproject.product2.model.dto.DessertDTO;
import com.nanoproject.product2.model.dto.ItemDTO;
import com.nanoproject.product2.model.dto.MemberDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private MemberDTO member;
    private MenuManager menuManager;
    private List<ItemDTO> items;
    private Scanner scanner;

    private Payment payment;

    public Menu(MemberDTO member) {
        this.member = member;
        menuManager = new MenuManager();
        items = new ArrayList<>();
        scanner = new Scanner(System.in);
        payment = new Payment();
        setItems();
    }

    private void setItems() {
        items.add(new BeverageDTO("아메리카노", 2000));
        items.add(new BeverageDTO("카페라떼", 3000));
        items.add(new BeverageDTO("카페모카", 4000));
        items.add(new DessertDTO("크로크무슈", 5000));
        items.add(new DessertDTO("치아바타", 6000));
    }

    public void run() {
        boolean isPayable = false;
        while (!isPayable) {
            showMenu();
            System.out.print("메뉴를 선택하세요 : ");
            int input = scanner.nextInt();
            int index = input - 1;
            scanner.nextLine();
            switch (input) {
                case 1, 2, 3 -> menuManager.addItem(new BeverageDTO(items.get(index).getName(), items.get(index).getPrice(), askHot()));
                case 4, 5 -> menuManager.addItem(new DessertDTO(items.get(index).getName(), items.get(index).getPrice(), askHeat()));
                case 6 -> menuManager.showBasket();
                case 7 -> menuManager.deleteItem(getItemNo());
                case 8 -> menuManager.clearBasket();
                case 9 -> isPayable = menuManager.isPayable();
                default -> System.out.println("잘못된 입력입니다.");
            }
            System.out.println();
        }
        payment.run(member, menuManager.getTotalPrice());
    }

    public void showMenu() {
        System.out.println("===== Menu =====");
        int number = 1;
        for (ItemDTO item : items) {
            System.out.printf("%d. %s\n", number++, item.getName());
        }
        System.out.printf("%d. 담은 목록 보기\n", number++);
        System.out.printf("%d. 담은 품목 삭제하기\n", number++);
        System.out.printf("%d. 담은 품목 전체 삭제하기\n", number++);
        System.out.printf("%d. 결제하기\n", number++);
    }

    private boolean askHot() {
        String isHot = null;
        while (true) {
            System.out.print("1. Hot / 2. Ice : ");
            isHot = scanner.nextLine();
            if (isHot.equals("1") || isHot.equals("2")) break;
            System.out.println("잘못된 입력입니다.");
        }
        return isHot.equals("1");
    }

    private boolean askHeat() {
        String isHeat = null;
        while (true) {
            System.out.print("오븐 토스팅을 하시겠습니까?(y/n) : ");
            isHeat = scanner.nextLine();
            if (isHeat.equalsIgnoreCase("y") || isHeat.equalsIgnoreCase("n")) break;
            System.out.println("잘못된 입력입니다.");
        }
        return isHeat.equalsIgnoreCase("y");
    }

    private int getItemNo() {
        int itemNo = -1;
        if (!menuManager.showBasket()) return itemNo;
        while (true) {
            System.out.print("몇 번 메뉴를 삭제하시겠습니까? : ");
            itemNo = scanner.nextInt();
            if (0 < itemNo && itemNo <= menuManager.getItemCount()) break;
            System.out.println("잘못된 입력입니다.");
        }
        return itemNo;
    }
}
