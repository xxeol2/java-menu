package menu;

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
}
