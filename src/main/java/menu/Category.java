package menu;

import java.util.List;
import java.util.Objects;

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
        if (!(o instanceof Category)) {
            return false;
        }
        Category that = (Category) o;
        return name == that.name;
    }
}
