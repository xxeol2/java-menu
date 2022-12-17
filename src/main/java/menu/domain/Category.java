package menu.domain;

import java.util.Arrays;

public enum Category {
    JAPANESE(1, "일식"),
    KOREAN(2, "한식"),
    CHINESE(3, "중식"),
    ASIAN(4, "아시안"),
    WESTERN(5, "양식");

    private static java.util.Collections Collections;
    private int index;
    private String name;

    Category(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static Category getCategoryByIndex(int index) {
        return Arrays.stream(values())
                .filter(c -> c.index == index)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return name;
    }
}
