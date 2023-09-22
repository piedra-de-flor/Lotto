package LottoGame.Lotto.model;

import LottoGame.Lotto.vo.Lotto;
import LottoGame.Lotto.vo.Money;
import LottoGame.Lotto.vo.Winner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerManager {
    private static final int NO_PROFIT_RATE = 0;
    private final WinningChecker winningChecker;
    private Winner winner;

    public WinnerManager() {
        this.winningChecker = new WinningChecker(new HashMap<>());
    }

    public void makeNewWinner(String numbers) {
        this.winner = new Winner(numbers);
    }

    public double calculatePrice(Money money, List<Lotto> lottos) {
        int inputMoney = money.getMoney();
        int winningPrice = winningChecker.getWinningPrice();

        if (winningPrice != NO_PROFIT_RATE) {
            return inputMoney / winningPrice;
        }
        return NO_PROFIT_RATE;
    }

    public Map<Integer, Integer> checkWinning(List<Lotto> lottos) {
        return winningChecker.checkWinning(lottos, winner.getWinner());
    }
}
