package org.example;

import org.example.utils.InputHandler;
import org.example.utils.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class Kiosk {
    private List<Menu> menus;

    public Kiosk() {
        this.menus = new ArrayList<>();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        while (true) {
            displayMainMenu();
            int choice = InputHandler.getIntInput("메뉴 번호를 선택하세요: ", 0, menus.size());

            if (choice == 0) {
                OutputHandler.printMessage("키오스크를 종료합니다.");
                break;
            }

            Menu selectedMenu = menus.get(choice - 1);
            while (true) {
                selectedMenu.displayMenu();
                int itemChoice = InputHandler.getIntInput("메뉴 번호를 선택하세요: ", 0, selectedMenu.getMenuItems().size());

                if (itemChoice == 0) {
                    break;
                }

                MenuItem selectedItem = selectedMenu.getMenuItems().get(itemChoice - 1);
                OutputHandler.printMessage("선택한 메뉴: " + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
            }
        }
    }

    private void displayMainMenu() {
        OutputHandler.printMessage("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            OutputHandler.printMessage((i + 1) + ". " + menus.get(i).getCategoryName());
        }
        OutputHandler.printMessage("0. 종료 | 종료");
    }
}
