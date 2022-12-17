package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static menu.validator.CoachValidator.validateCoachNumbers;
import static menu.validator.MenuValidator.validateHateMenu;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;

public class InputView {

    public List<Coach> readCoaches() {
        List<String> coachNames = readWordsSeparatedByComma();
        validateCoachNumbers(coachNames);
        return coachNames.stream().map(Coach::new).collect(Collectors.toList());
    }

    public List<Menu> readMenus() {
        String input = inputWord();
        if (input.isBlank()) {
            return null;
        }
        List<String> menuNames = separateWordByComma(input);
        validateHateMenu(menuNames);
        return menuNames.stream().map(Category::findMenuByName).collect(Collectors.toList());
    }

    private List<String> deleteBlanks(List<String> words) {
        return words.stream().map(String::trim).collect(Collectors.toList());
    }

    private String inputWord() {
        return readLine().trim();
    }

    private List<String> separateWordByComma(String word) {
        List<String> words = Arrays.stream(word.split(","))
                .collect(Collectors.toList());
        return deleteBlanks(words);
    }

    private List<String> readWordsSeparatedByComma() {
        String word = inputWord();
        return separateWordByComma(word);
    }
}
