package menu.view;

public class OutputView {

    public static final String INPUT_COACH_NAMES = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public void printInputCoachNames() {
        System.out.println(INPUT_COACH_NAMES);
    }

    public void printError(Exception e) {
        System.out.println(e.getMessage());
    }
}
