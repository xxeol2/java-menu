package menu;

import static menu.domain.Category.findMenuByName;
import static menu.validator.CoachValidator.validateCoach;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.domain.Menu;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {

    @ValueSource(strings = {"우동", "스시", "된장찌개"})
    @ParameterizedTest
    void 메뉴_이름으로_메뉴_객체_가져오기(String menuName) {
        assertThat(findMenuByName(menuName)).isInstanceOf(Menu.class);
    }

    @ValueSource(strings = {"됴요", "둉", "듀듀듀"})
    @ParameterizedTest
    void 없는_메뉴_호출시_에러처리(String menuName) {
        assertThatThrownBy(() -> findMenuByName(menuName)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Test
    void 메뉴_이름이_중복되면_에러처리한다() {
        List<String> menuNames = List.of("뇨끼", "뇨끼");
        assertThatThrownBy(() -> validateCoach(menuNames)).isInstanceOf(
                IllegalArgumentException.class);
    }
}
