package LottoGame.Lotto;

import LottoGame.Lotto.vo.Winner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinnerTest {
    @DisplayName("당첨 번호 잘못된 입력 테스트 - 문자열 입력시")
    @ParameterizedTest
    @ValueSource(strings = {"가, 나, 다", "1, 2, 다", "ㅋㄴㅇ마ㅜㄴ"})
    void 당첨_번호_잘못된_입력_테스트_문자열(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            makeTestWinner(input);
        });
    }

    @DisplayName("당첨 번호 잘못된 입력 테스트 - 공백 입력시")
    @ParameterizedTest
    @ValueSource(strings = {"가, , 다", "  ", ",,,"})
    void 당첨_번호_잘못된_입력_테스트_공백(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            makeTestWinner(input);
        });
    }

    @DisplayName("당첨 번호 잘못된 입력 테스트 - 중복된 숫자 입력시")
    @ParameterizedTest
    @ValueSource(strings = {"1,1,1", "1, 2, 2", "1,1,2,2,3"})
    void 당첨_번호_잘못된_입력_테스트_중복(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            makeTestWinner(input);
        });
    }

    @DisplayName("당첨 번호 잘못된 입력 테스트 - 1~45 이외의 숫자 입력시")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "55,44,3,77,100", "44,321,0,-14,99"})
    void 당첨_번호_잘못된_입력_테스트_범위_밖(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            makeTestWinner(input);
        });
    }

    private Winner makeTestWinner(String input) {
        return new Winner(Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
    }
}