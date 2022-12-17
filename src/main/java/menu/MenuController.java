package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.service.CategoryRecommender;
import menu.service.MenuRecommender;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CategoryRecommender categoryRecommender = new CategoryRecommender();
    private final MenuRecommender menuRecommender = new MenuRecommender();

    // TODO: 리팩터링(메서드로 빼기)
    public void play() {
        outputView.printStartProgram();
        List<Coach> coaches = repeat(this::inputCoaches);
        for (Coach coach : coaches) {
            List<Menu> menus = repeat(() -> inputHateMenus(coach));
            if (menus != null) {
                coach.setHateMenus(menus);
            }
        }
        List<Category> recommendedCategory = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Category category = categoryRecommender.pickOneCategory(recommendedCategory);
            for (Coach coach : coaches) {
                Menu menu = menuRecommender.recommendMenuForCoach(coach, category);
                coach.addRecommendMenu(menu);
            }
            recommendedCategory.add(category);
        }
        outputView.printRecommendResult(recommendedCategory, coaches);
    }

    private List<Coach> inputCoaches() {
        outputView.printInputCoachNames();
        return inputView.readCoaches();
    }

    private List<Menu> inputHateMenus(Coach coach) {
        outputView.printInputHateMenu(coach);
        return inputView.readMenus();
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return repeat(inputReader);
        }
    }

}
