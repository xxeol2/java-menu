package menu.service;

import static menu.domain.Category.getCategoryByIndex;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;

public class CategoryRecommender {

    private static final int SAME_CATEGORY_MAX_COUNT = 2;
    private static final int DAY_NUMBERS = 5;

    // TODO: 레포지터리로 이동
    private final List<Category> recommendedCategories = new ArrayList<>();

    public List<Category> recommendCategories() {
        for (int i = 0; i < DAY_NUMBERS; i++) {
            pickOneCategory();
        }
        return recommendedCategories;
    }

    private void pickOneCategory() {
        Category category;
        while (true) {
            category = getCategoryByIndex(
                    Randoms.pickNumberInRange(1, Category.values().length));
            if (!isValidCategory(category)) {
                continue;
            }
            recommendedCategories.add(category);
            break;
        }
    }

    private boolean isValidCategory(Category category) {
        long count = recommendedCategories.stream().filter(c -> c.equals(category)).count();
        return count < SAME_CATEGORY_MAX_COUNT;
    }
}
