package menu;

import java.util.List;
import java.util.function.Supplier;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        List<Coach> coaches = repeat(this::inputCoaches);
    }

    private List<Coach> inputCoaches() {
        outputView.printInputCoachNames();
        return inputView.readCoaches();
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
