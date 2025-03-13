package org.example.utils;
import java.util.Scanner;

public class InputHandler {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntInput(String message, int min, int max) {

        return ExceptionHandler.handle(() -> {
            System.out.print(message);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice < min || choice > max) {
                throw new IllegalArgumentException("잘못된 입력입니다. " + min + "부터 " + max + "까지 입력 가능합니다.");
            }
            return choice;
        });
    }
}
