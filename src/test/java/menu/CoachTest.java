package menu;

import static menu.validator.CoachValidator.validateCoach;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import menu.domain.Coach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @ValueSource(strings = {"일이", "일이삼", "일이삼사"})
    @ParameterizedTest
    void 코치_이름은_최소_2글자_최대_4글자이다(String coachName) {
        assertThat(new Coach(coachName)).isInstanceOf(Coach.class);
    }

    @ValueSource(strings = {"", "일", "일이삼사오"})
    @ParameterizedTest
    void 코치_이름이_2글자보다_짧거나_4글자보다_길면_에러처리한다(String coachName) {
        assertThatThrownBy(() -> new Coach(coachName)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 코치_이름이_중복되면_에러처리한다() {
        List<String> coachNames = List.of("포비", "포비", "설희");
        assertThatThrownBy(() -> validateCoach(coachNames)).isInstanceOf(
                IllegalArgumentException.class);
    }
}