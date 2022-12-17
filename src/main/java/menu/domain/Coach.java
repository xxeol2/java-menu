package menu.domain;

import static menu.validator.CoachValidator.validateCoachName;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private List<Menu> hateMenus;

    public Coach(String name) {
        validateCoachName(name);
        this.name = name;
        this.hateMenus = new ArrayList<>();
    }

    public void setHateMenus(List<Menu> menus) {
        hateMenus.addAll(menus);
    }

    @Override
    public String toString() {
        return name;
    }
}
