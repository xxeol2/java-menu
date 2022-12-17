package menu;

import java.util.List;

public class Category {

    private final String name;
    private final List<Menu> menus;

    public Category(String name, List<Menu> menus) {
        this.name = name;
        this.menus = menus;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    @Override
    public String toString() {
        return name;
    }
}
