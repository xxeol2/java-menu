package menu;

import static menu.validator.CoachValidator.validateCoachName;

public class Coach {

    private final String name;

    public Coach(String name) {
        validateCoachName(name);
        this.name = name;
    }
}
