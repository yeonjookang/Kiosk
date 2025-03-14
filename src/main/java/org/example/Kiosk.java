package org.example;

import org.example.utils.InputHandler;
import org.example.utils.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class Kiosk {
    private List<Menu> menus;
    private Cart cart;

    public Kiosk() {
        this.menus = new ArrayList<>();
        this.cart = new Cart();
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        while (true) {
            displayMainMenu();
            //장바구니가 비어있으면 메뉴 갯수만큼만, 담겨있으면 Orders, Cancel 메뉴까지 입력받도록
            int choice = InputHandler.getIntInput("메뉴 번호를 선택하세요: ", 0, cart.isEmpty() ? menus.size() : menus.size() + 2);

            if (choice == 0) {
                OutputHandler.printMessage("키오스크를 종료합니다.");
                break;
            }

            //장바구니에 메뉴가 담겨있고, Orders 메뉴를 누른 경우
            if (!cart.isEmpty() && choice == menus.size() + 1) {
                displayOrderMenu();
                continue;
            } //장바구니에 메뉴가 담겨있고, Cancle 메뉴를 누른 경우
            else if (!cart.isEmpty() && choice == menus.size() + 2) {
                cart.clearCart();
                OutputHandler.printMessage("진행 중인 주문이 취소되었습니다.");
                continue;
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
                OutputHandler.printMessage("위 메뉴를 장바구니에 추가하시겠습니까?\n1. 확인  2. 취소");
                int confirm = InputHandler.getIntInput("입력: ", 1, 2);
                if (confirm == 1) {
                    cart.addItem(selectedItem);
                    break;
                }
            }
        }
    }

    private void displayMainMenu() {
        OutputHandler.printMessage("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            OutputHandler.printMessage((i + 1) + ". " + menus.get(i).getCategoryName());
        }
        if (!cart.isEmpty()) {
            OutputHandler.printMessage("\n[ ORDER MENU ]");
            OutputHandler.printMessage((menus.size() + 1) + ". Orders | 장바구니를 확인 후 주문합니다.");
            OutputHandler.printMessage((menus.size() + 2) + ". Cancel | 진행중인 주문을 취소합니다.");
        }
        OutputHandler.printMessage("0. 종료 | 종료");
    }

    private void displayOrderMenu() {
        cart.displayCart();
        OutputHandler.printMessage("\n1. 주문  2.메뉴 취소  3. 메뉴판");
        int choice = InputHandler.getIntInput("입력: ", 1, 3);
        if (choice == 1) {
            displayDiscountInfo();
            OutputHandler.printMessage("주문이 완료되었습니다. 금액은 W " + cart.getTotal() + " 입니다.");
            cart.clearCart();
            return;
        }
        if (choice == 2){
            int cancelChoice = InputHandler.getIntInput("취소하실 메뉴 번호를 입력해주세요: ", 1, cart.getTotalCount());
            cart.removeItem(cancelChoice);
        }
    }

    private void displayDiscountInfo() {
        OutputHandler.printMessage(UserType.getDiscountInfo());
        int choice = InputHandler.getIntInput("입력: ", 1,UserType.getTotalCount());
        cart.discount(choice);
    }
}
