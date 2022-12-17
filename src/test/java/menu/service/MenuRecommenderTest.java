package menu.service;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;
import static menu.domain.Category.getCategoryByIndex;
import static menu.domain.Category.getTotalMenu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class MenuRecommenderTest {

    MenuRecommender menuRecommender;

    @BeforeEach
    void beforeEach() {
        menuRecommender = new MenuRecommender();
    }

    @RepeatedTest(10)
    void 해당_요일의_카테고리의_메뉴를_추천한다() {
        Coach coach = initCoach();
        Category category = getRandomCategory();
        Menu menu = menuRecommender.recommendMenuForCoach(coach, category);
        Assertions.assertThat(category.getMenus().contains(menu)).isTrue();
    }

    @RepeatedTest(10)
    void 각_코치가_먹지_못하는_메뉴는_추천해주지_않는다() {
        Coach coach = initCoach();
        Category category = getRandomCategory();
        Menu menu = menuRecommender.recommendMenuForCoach(coach, category);
        Assertions.assertThat(coach.isValidMenu(menu)).isTrue();
    }

    private Coach initCoach() {
        Coach coach = new Coach("설희");
        List<Menu> shuffledMenu = shuffle(getTotalMenu());
        coach.setHateMenus(List.of(shuffledMenu.get(0), shuffledMenu.get(1)));
        return coach;
    }

    private Category getRandomCategory() {
        return getCategoryByIndex(
                Randoms.pickNumberInRange(1, Category.values().length));
    }
}