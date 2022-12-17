package menu;

import java.util.Objects;

public class Menu {

    private final String name;

    public Menu(String name) {
        this.name = name;
    }

    public static Menu of(String name) {
        return new Menu(name);
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
