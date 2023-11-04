package LottoGame.Lotto;

import LottoGame.Lotto.vo.BonusBall;
import LottoGame.Lotto.vo.Winner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BonusBallTest {
    @DisplayName("보너스 볼 숫자 입력 유효성 테스트 - 문자열 입력시")
    @ParameterizedTest
    @ValueSource(strings = {"가, 나, 다", "1, 2, 다", "ㅋㄴㅇ마ㅜㄴ"})
    void 당첨_번호_잘못된_입력_테스트_문자열(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BonusBall(input, makeTestWinner());
        });
    }

    @DisplayName("보너스 볼 숫자 입력 유효성 테스트 - 공백 입력시")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void 당첨_번호_잘못된_입력_테스트_공백(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BonusBall(input, makeTestWinner());
        });
    }

    @DisplayName("보너스 볼 숫자 입력 유효성 테스트 - 중복된 숫자 입력시")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    void 당첨_번호_잘못된_입력_테스트_중복(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BonusBall(input, makeTestWinner());
        });
    }

    @DisplayName("보너스 볼 숫자 입력 유효성 테스트 - 1~45 이외의 숫자 입력시")
    @ParameterizedTest
    @ValueSource(strings = {"0", "50", "100"})
    void 당첨_번호_잘못된_입력_테스트_범위_밖(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new BonusBall(input, makeTestWinner());
        });
    }

    private Winner makeTestWinner() {
        int[] testList = {1,2,3,4,5,6};
        return new Winner(Arrays.stream(testList).boxed().collect(Collectors.toList()));
    }
}
