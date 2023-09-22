package LottoGame.Lotto.model;

import LottoGame.Lotto.vo.Lotto;
import LottoGame.Lotto.vo.Money;
import LottoGame.Lotto.vo.Winnings;

import java.util.List;
import java.util.Map;

public class WinningChecker {
    private static final int NO_PROFIT = 0;
    private final Winnings winnings;

    public WinningChecker(Map<Integer, Integer> resultMap) {
        this.winnings = new Winnings(resultMap);
    }

    public Map<Integer, Integer> getWinnings() {
        return winnings.getWinnings();
    }

    public void checkWinning(List<Lotto> lottos, List<Integer> winner) {
        for (Lotto lotto : lottos) {
            int correctCount = countCorrect(lotto.getNumbers(), winner);
            winnings.add(correctCount);
        }
    }

    private int countCorrect(List<Integer> numbers, List<Integer> winner) {
        return (int) numbers.stream()
                .filter(winner::contains)
                .count();
    }

    public double calculateProfit(Money money) {
        int inputMoney = money.getMoney();

        if (winnings.getWinningPrice() != NO_PROFIT) {
            return inputMoney / winnings.getWinningPrice();
        }
        return NO_PROFIT;
    }
}
