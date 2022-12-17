package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public interface MenuRecommender {

    Menu recommendMenuForCoach(Coach coach, Category category);
}
