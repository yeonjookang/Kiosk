package org.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 햄버거 메뉴 리스트
        List<String> menuItems = new ArrayList<>();
        menuItems.add("ShackBurger ($6.9) - 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        menuItems.add("SmokeShack ($8.9) - 베이컨, 체리 페퍼, 쉑소스가 토핑된 치즈버거");
        menuItems.add("Shroom Burger ($9.4) - 포토벨로 버섯 패티와 치즈가 들어간 버거");

        while (true) {
            System.out.println("=== 햄버거 메뉴 ===");
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i));
            }
            System.out.println("0. 종료");

            System.out.print("메뉴 번호를 선택하세요: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 0) {
                    System.out.println("키오스크를 종료합니다.");
                    break;
                } else if (choice >= 1 && choice <= menuItems.size()) {
                    System.out.println("선택한 메뉴: " + menuItems.get(choice - 1));
                } else {
                    System.out.println("잘못된 입력입니다. 메뉴 번호를 확인하세요.");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해야 합니다.");
            }
        }

        scanner.close();
    }
}