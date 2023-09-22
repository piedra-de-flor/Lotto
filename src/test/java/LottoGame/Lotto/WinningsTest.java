package LottoGame.Lotto;

import LottoGame.Lotto.vo.Winnings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningsTest {
    @DisplayName("당첨된 로또 횟수 Map 생성 테스트")
    @Test
    void 당첨된_로또_횟수_Map_생성_테스트() {
        Winnings winnings = new Winnings(new HashMap<>());
        Set<Integer> keySet = new HashSet<>();

        keySet.add(3);
        keySet.add(4);
        keySet.add(5);
        keySet.add(6);

        assertThat(winnings.getWinnings().keySet()).isEqualTo(keySet);
    }

    @DisplayName("당첨된 로또 횟수 추가 실패 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 0})
    void 당첨된_로또_횟수_추가_실패_테스트(int input) {
        Winnings winnings = new Winnings(new HashMap<>());
        winnings.add(input);

        assertThat(winnings.getWinnings().values().contains(1)).isEqualTo(false);
    }

    @DisplayName("당첨된 로또 횟수 추가 성공 테스트")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void 당첨된_로또_횟수_추가_성공_테스트(int input) {
        Winnings winnings = new Winnings(new HashMap<>());
        winnings.add(input);

        assertThat(winnings.getWinnings().values().contains(1)).isEqualTo(true);
    }
}
