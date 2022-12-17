package menu;

import static menu.validator.CoachValidator.validateCoachName;

public class Coach {

    private final String name;

    private Coach(String name) {
        this.name = name;
    }

    public static Coach of(String name) {
        validateCoachName(name);
        return new Coach(name);
    }
}
