package LottoGame.Lotto;

import LottoGame.Lotto.model.LottoManager;
import LottoGame.Lotto.model.WinningChecker;
import LottoGame.Lotto.vo.Winner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningsCheckerTest {
    @DisplayName("당첨된 로또 횟수 Map 생성 테스트")
    @Test
    void 당첨된_로또_횟수_Map_생성_테스트() {
        WinningChecker winningChecker = new WinningChecker(new HashMap<>());
        LottoManager lottoManager = new LottoManager();


        lottoManager.makeLottos(1);
        List<Integer> testWinner = lottoManager.getLottos().get(0).getNumbers();
        String test = testWinner.toString().substring(1, testWinner.toString().length() - 1);
        Winner winner = new Winner(test);

        winningChecker.checkWinning(lottoManager.getLottos(), winner.getWinner());

        assertThat(winningChecker.getWinnings().get(6)).isEqualTo(1);
    }
}
