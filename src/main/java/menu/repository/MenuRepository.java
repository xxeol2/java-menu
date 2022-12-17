package menu.repository;

import static menu.domain.Category.ASIAN;
import static menu.domain.Category.CHINESE;
import static menu.domain.Category.JAPANESE;
import static menu.domain.Category.KOREAN;
import static menu.domain.Category.WESTERN;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Menu;
import menu.exception.menu.WrongMenuNameException;

public class MenuRepository {

    private static List<Menu> savedMenus;

    static {
        savedMenus = new ArrayList<>();
        loadMenu(JAPANESE, "규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼");
        loadMenu(KOREAN, "김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음");
        loadMenu(CHINESE, "깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채");
        loadMenu(ASIAN, "팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜");
        loadMenu(WESTERN, "라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니");
    }

    public static List<Menu> findAllMenus() {
        return java.util.Collections.unmodifiableList(savedMenus);
    }

    public static Menu findMenuByName(String menuName) {
        return savedMenus.stream().filter(menu -> menu.checkMenuName(menuName))
                .findAny()
                .orElseThrow(WrongMenuNameException::new);
    }

    public static List<String> findMenuNamesByCategory(Category category) {
        return savedMenus.stream()
                .filter(menu -> menu.checkCategory(category))
                .map(Menu::getName)
                .collect(Collectors.toList());
    }

    private static void save(List<Menu> menus) {
        savedMenus.addAll(menus);
    }

    private static void loadMenu(Category category, String MenuNames) {
        save(convertToMenus(category, MenuNames));
    }

    private static List<Menu> convertToMenus(Category category, String menuNames) {
        List<Menu> menus = new ArrayList<>();
        for (String menuName : menuNames.split(", ")) {
            menus.add(new Menu(category, menuName));
        }
        return menus;
    }

}
