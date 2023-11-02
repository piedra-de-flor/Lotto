package LottoGame.Lotto;

import LottoGame.Lotto.vo.Winnings;
import LottoGame.Lotto.vo.WinningsCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningsTest {
    @DisplayName("당첨된 로또 횟수 추가 실패 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 0})
    void 당첨된_로또_횟수_추가_실패_테스트(int input) {
        Winnings winnings = new Winnings(new HashMap<>());
        winnings.recordInNotFiveCorrectCount(input);

        assertThat(winnings.getWinnings().values().stream()
                .anyMatch(integer -> integer > 0))
                .isEqualTo(false);
    }

    @DisplayName("당첨된 로또 횟수 추가 성공 테스트 (2,3등 제외)")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 6})
    void 당첨된_로또_횟수_추가_성공_테스트_1등_4등_5등(int input) {
        Winnings winnings = new Winnings(new HashMap<>());
        winnings.recordInNotFiveCorrectCount(input);

        assertThat(winnings.getWinnings().values().stream()
                .anyMatch(integer -> integer > 0)).isEqualTo(true);
    }

    @DisplayName("당첨된 로또 횟수 추가 성공 테스트 (3등만)")
    @Test
    void 당첨된_로또_횟수_추가_성공_테스트_3등() {
        Winnings winnings = new Winnings(new HashMap<>());
        winnings.recordInNotFiveCorrectCount(5);

        assertThat(winnings.getWinnings().entrySet().stream()
                .filter(winningsCountIntegerEntry -> winningsCountIntegerEntry.getValue() > 0)
                .anyMatch(winningsCountIntegerEntry -> winningsCountIntegerEntry.getKey() == WinningsCount.THIRD_PLACE))
                .isEqualTo(true);
    }

    @DisplayName("당첨된 로또 횟수 추가 성공 테스트 (2등만)")
    @Test
    void 당첨된_로또_횟수_추가_성공_테스트_2등() {
        Winnings winnings = new Winnings(new HashMap<>());
        winnings.recordInFiveCorrectCount(true);

        assertThat(winnings.getWinnings().entrySet().stream()
                .filter(winningsCountIntegerEntry -> winningsCountIntegerEntry.getValue() > 0)
                .anyMatch(winningsCountIntegerEntry -> winningsCountIntegerEntry.getKey() == WinningsCount.SECOND_PLACE))
                .isEqualTo(true);
    }
}