package menu.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static menu.validator.CoachValidator.validateCoachNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.Coach;

public class InputView {

    public List<Coach> readCoaches() {
        List<String> coachNames = Arrays.stream(readLine().trim().split(","))
                .collect(Collectors.toList());
        coachNames = deleteBlanks(coachNames);
        validateCoachNumbers(coachNames);
        return coachNames.stream().map(Coach::new).collect(Collectors.toList());
    }

    private List<String> deleteBlanks(List<String> words) {
        return words.stream().map(String::trim).collect(Collectors.toList());
    }
}
