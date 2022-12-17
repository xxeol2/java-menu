package menu.domain;

import static menu.validator.CoachValidator.validateCoachName;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private List<Menu> hateMenus;
    private List<Menu> recommendedMenus;

    public Coach(String name) {
        validateCoachName(name);
        this.name = name;
        this.hateMenus = new ArrayList<>();
        this.recommendedMenus = new ArrayList<>();
    }

    public List<Menu> getRecommendedMenus() {
        return recommendedMenus;
    }

    // TODO: 이것도 세터인가?
    public void setHateMenus(List<Menu> menus) {
        hateMenus.addAll(menus);
    }

    public void setRecommendedMenus(List<Menu> menus) {
        recommendedMenus.addAll(menus);
    }

    public boolean isValidMenu(Menu menu) {
        return !hateMenus.contains(menu);
    }

    @Override
    public String toString() {
        return name;
    }
}
