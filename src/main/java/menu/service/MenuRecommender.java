package menu.service;

import static menu.domain.Category.getTotalMenu;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class MenuRecommender {

    public List<Menu> recommendMenuForCoach(Coach coach, List<Category> categories) {
        List<Menu> recommendedMenus = new ArrayList<>();
        List<Menu> totalMenu = getTotalMenu();
        Menu menu;
        // TODO: 리팩토링 (depth)
        for (int i = 0; i < categories.size(); i++) {
            do {
                Category category = categories.get(i);
                List<Menu> categoryMenus = totalMenu.stream().filter(m -> m.checkCategory(category))
                        .collect(Collectors.toList());
                menu = categoryMenus.get(Randoms.pickNumberInRange(0, categoryMenus.size() - 1));
                if (!coach.isValidMenu(menu) || recommendedMenus.contains(menu)) {
                    continue;
                }
                break;
            } while (true);
            recommendedMenus.add(menu);
        }
        return recommendedMenus;
    }
}
