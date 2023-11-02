package LottoGame.Lotto;

import LottoGame.Lotto.model.LottoManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoManagerTest {
    @DisplayName("make lotto test")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 로또_만들기_테스트(int number) {
        LottoManager manager = new LottoManager();
        manager.makeLottos(number);

        assertThat(manager.getLottos().size()).isEqualTo(number);
    }
}