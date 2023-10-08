package LottoGame.Lotto.model;

import LottoGame.Lotto.vo.Lotto;
import LottoGame.Lotto.vo.Winnings;
import LottoGame.Lotto.vo.WinningsCount;

import java.util.List;
import java.util.Map;

public class WinningChecker {
    private final Winnings winnings;

    public WinningChecker(Map<WinningsCount, Integer> results) {
        this.winnings = new Winnings(results);
    }

    public Map<WinningsCount, Integer> checkWinning(List<Lotto> lottos, List<Integer> winner, int bonus) {
        for (Lotto lotto : lottos) {
            int correctCount = countCorrect(lotto.getNumbers(), winner);
            recodeWinning(correctCount, lotto, bonus);
        }

        return winnings.getWinnings();
    }

    private void recodeWinning(int correctCount, Lotto lotto, int bonus) {
        if (correctCount == WinningsCount.SECOND_PLACE.correctCount) {
            winnings.recordInFiveCorrectCount(isBonus(bonus, lotto));
            return;
        }
        winnings.recordInNotFiveCorrectCount(correctCount);
    }

    private int countCorrect(List<Integer> numbers, List<Integer> winner) {
        return (int) numbers.stream()
                .filter(winner::contains)
                .count();
    }

    private boolean isBonus(int bonus, Lotto lotto) {
        return lotto.getNumbers().stream().anyMatch(integer -> integer == bonus);
    }

    public int getWinningPrice() {
        return winnings.calculateWinningPrice();
    }
}