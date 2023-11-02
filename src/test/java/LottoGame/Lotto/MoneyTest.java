package LottoGame.Lotto;

import LottoGame.Lotto.vo.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {
    int lottoPrice = 1000;

    @DisplayName("money Input valid test1")
    @ParameterizedTest
    @ValueSource(strings = {"-1000", "0", "500", "5200"})
    void 받은_금액_유효성_테스트_1(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Money money = new Money(input, lottoPrice);
        });
    }

    @DisplayName("money Input valid test2")
    @ParameterizedTest
    @ValueSource(strings = {"wrongInput1", "wrongInput2", "wrongInput3"})
    void 받은_금액_유효성_테스트_2(String input) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Money money = new Money(input, lottoPrice);
        });
    }
}