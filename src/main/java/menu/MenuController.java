package menu;

import java.util.List;
import java.util.function.Supplier;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        List<Coach> coaches = repeat(this::inputCoaches);
        for (Coach coach : coaches) {
            List<Menu> menus = repeat(() -> inputHateMenus(coach));
            if (menus != null) {
                coach.setHateMenus(menus);
            }
        }
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
