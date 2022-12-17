package menu.service;

import java.util.List;
import menu.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryRecommenderTest {

    CategoryRecommender categoryRecommender;

    @BeforeEach
    void beforeEach() {
        categoryRecommender = new CategoryRecommender();
    }

    @Test
    void 각_요일의_카테고리를_추천한다() {
        List<Category> categories = categoryRecommender.recommendCategories();

        for (Category category : categories) {
            Assertions.assertThat(category).isInstanceOf(Category.class);
        }
    }
}