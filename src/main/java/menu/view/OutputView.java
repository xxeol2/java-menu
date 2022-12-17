package menu.view;

import menu.domain.Coach;

public class OutputView {

    public static final String INPUT_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";
    public static final String INPUT_HATE_MENUS = "(이)가 못 먹는 메뉴를 입력해 주세요.";

    public void printInputCoachNames() {
        System.out.println(INPUT_COACH_NAMES);
    }

    public void printInputHateMenu(Coach coach) {
        System.out.println(coach + INPUT_HATE_MENUS);
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }
}
