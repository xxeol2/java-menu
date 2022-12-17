package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menu {

    private final String name;

    public Menu(String name) {
        this.name = name;
    }

    public static Menu of(String name) {
        return new Menu(name);
    }

    public static List<Menu> convertToMenus(String menuNames) {
        List<Menu> menus = new ArrayList<>();
        for (String menuName : menuNames.split(", ")) {
            menus.add(Menu.of(menuName));
        }
        return menus;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Menu)) {
            return false;
        }
        Menu that = (Menu) o;
        return name == that.name;
    }
}
