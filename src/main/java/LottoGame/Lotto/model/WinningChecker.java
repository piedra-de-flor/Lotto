package LottoGame.Lotto.model;

import LottoGame.Lotto.vo.Lotto;
import LottoGame.Lotto.vo.Money;
import LottoGame.Lotto.vo.Winnings;

import java.util.List;
import java.util.Map;

public class WinningChecker {
    private final Winnings winnings;

    public WinningChecker(Map<Integer, Integer> resultMap) {
        this.winnings = new Winnings(resultMap);
    }

    public Map<Integer, Integer> checkWinning(List<Lotto> lottos, List<Integer> winner) {
        for (Lotto lotto : lottos) {
            int correctCount = countCorrect(lotto.getNumbers(), winner);
            winnings.add(correctCount);
        }

        return winnings.getWinnings();
    }

    private int countCorrect(List<Integer> numbers, List<Integer> winner) {
        return (int) numbers.stream()
                .filter(winner::contains)
                .count();
    }

    public int getWinningPrice() {
        return winnings.calculateWinningPrice();
    }
}
