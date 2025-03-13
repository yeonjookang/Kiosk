package org.example.utils;

public class ExceptionHandler {
    public interface Task<T> {
        T execute();
    }

    public static <T> T handle(Task<T> task) {
        while (true) {
            try {
                return task.execute();
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
