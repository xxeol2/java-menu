package menu;

import menu.service.RandomCategoryRecommender;
import menu.service.RandomMenuRecommender;

public class Application {

    public static void main(String[] args) {
        MenuController menuController = new MenuController(new RandomCategoryRecommender(),
                new RandomMenuRecommender());
        menuController.play();
    }
}
