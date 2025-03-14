package org.example;

import org.example.utils.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName;
    private List<MenuItem> menuItems;

    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public List<MenuItem> getMenuItems() {
        //리스트 직접 수정 방지
        return new ArrayList<>(menuItems);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void displayMenu() {
        OutputHandler.printMessage("=== " + categoryName + " 메뉴 ===");
        for (int i = 0; i < menuItems.size(); i++) {
            OutputHandler.printMessage((i + 1) + ". " + menuItems.get(i));
        }
        OutputHandler.printMessage("0. 종료");
    }
}
