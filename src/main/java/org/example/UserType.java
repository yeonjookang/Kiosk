package org.example;

public enum UserType {

    NATIONAL_MERIT("국가유공자", 10),
    SOLDIER("군인" ,5),
    STUDENT("학생", 3),
    NORMAL("일반인", 0);

    private final String displayName;
    private final int discountRate;

    UserType(String displayName, int discountRate) {
        this.displayName = displayName;
        this.discountRate = discountRate;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public static String getDiscountInfo() {
        StringBuilder sb = new StringBuilder("할인 정보를 입력해주세요.\n");
        int index = 1;
        for (UserType type : UserType.values()) {
            sb.append(index).append(". ").append(type).append("\n");
            index++;
        }
        return sb.toString();
    }

    public static int getTotalCount() {
        return UserType.values().length;
    }

        @Override
    public String toString() {
        return displayName + " : " + discountRate + "%";
    }
}
