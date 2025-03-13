package org.example;

import org.example.utils.InputHandler;
import org.example.utils.OutputHandler;

import java.util.List;

public class Kiosk {
    private List<MenuItem> menuItems;

    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = InputHandler.getIntInput("메뉴 번호를 선택하세요: ", 0, menuItems.size());

            if (choice == 0) {
                OutputHandler.printMessage("키오스크를 종료합니다.");
                break;
            }

            MenuItem selectedItem = menuItems.get(choice - 1);
            OutputHandler.printMessage("선택한 메뉴: " + selectedItem.getName());
        }
    }

    private void displayMenu() {
        OutputHandler.printMessage("=== 햄버거 메뉴 ===");
        for (int i = 0; i < menuItems.size(); i++) {
            OutputHandler.printMessage((i + 1) + ". " + menuItems.get(i));
        }
        OutputHandler.printMessage("0. 종료");
    }
}
