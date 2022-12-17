package menu.service;

import static camp.nextstep.edu.missionutils.Randoms.shuffle;
import static menu.repository.MenuRepository.findMenuByName;
import static menu.repository.MenuRepository.findMenuNamesByCategory;

import java.util.List;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class RandomMenuRecommender implements MenuRecommender {

    @Override
    public Menu recommendMenuForCoach(Coach coach, Category category) {
        List<String> categoryMenus = findMenuNamesByCategory(category);
        while (true) {
            Menu menu = findMenuByName(shuffle(categoryMenus).get(0));
            if (!coach.isValidMenu(menu) || coach.isAlreadyRecommended(menu)) {
                continue;
            }
            return menu;
        }
    }
}
