package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();

        Menu burgerMenu = new Menu("Burgers");
        burgerMenu.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼, 쉑소스가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgerMenu.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinksMenu = new Menu("Drinks");
        drinksMenu.addMenuItem(new MenuItem("Coke", 2.0, "시원한 콜라"));
        drinksMenu.addMenuItem(new MenuItem("Lemonade", 2.5, "상큼한 레모네이드"));

        Menu dessertsMenu = new Menu("Desserts");
        dessertsMenu.addMenuItem(new MenuItem("Ice Cream", 3.0, "바닐라 아이스크림"));
        dessertsMenu.addMenuItem(new MenuItem("Brownie", 3.5, "초콜릿 브라우니"));

        kiosk.addMenu(burgerMenu);
        kiosk.addMenu(drinksMenu);
        kiosk.addMenu(dessertsMenu);

        kiosk.start();
    }
}