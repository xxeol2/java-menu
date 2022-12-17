package menu.service;

import java.util.List;
import menu.domain.Category;

public interface CategoryRecommender {

    Category pickOneCategory(List<Category> recommendedCategories);
}