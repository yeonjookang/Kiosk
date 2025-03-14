package org.example;

import org.example.utils.OutputHandler;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<MenuItem> cartItems;
    private double total;

    public Cart() {
        this.cartItems = new ArrayList<>();
        this.total = 0.0;
    }

    public void addItem(MenuItem item) {
        cartItems.add(item);
        total += item.getPrice();
        OutputHandler.printMessage(item.getName() + " 이 장바구니에 추가되었습니다.");
    }

    public boolean isEmpty() {
        return cartItems.isEmpty();
    }

    public void displayCart() {
        OutputHandler.printMessage("[ Orders ]");
        for (MenuItem item : cartItems) {
            OutputHandler.printMessage(item.getName() + " | W " + item.getPrice() + " | " + item.getDescription());
        }
        OutputHandler.printMessage("\n[ Total ]");
        OutputHandler.printMessage("W " + total);
    }

    public void clearCart() {
        cartItems.clear();
        total = 0.0;
    }

    public double getTotal() {
        return total;
    }
}
