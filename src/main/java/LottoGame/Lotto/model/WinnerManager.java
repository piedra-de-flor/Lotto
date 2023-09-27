package LottoGame.Lotto.model;

import LottoGame.Lotto.vo.Lotto;
import LottoGame.Lotto.vo.Money;
import LottoGame.Lotto.vo.ProfitRate;
import LottoGame.Lotto.vo.Winner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerManager {
    private final WinningChecker winningChecker;
    private Winner winner;
    private ProfitRate profitRate;

    public WinnerManager() {
        this.winningChecker = new WinningChecker(new HashMap<>());
    }

    public void makeNewWinner(String numbers) {
        this.winner = new Winner(numbers);
    }

    public double calculateProfit(Money money, List<Lotto> lottos) {
        int inputMoney = money.getValue();
        int winningPrice = calculatePrice();

        this.profitRate = new ProfitRate(inputMoney, winningPrice);
        return profitRate.getProfitRate();
    }

    public int calculatePrice() {
        return winningChecker.getWinningPrice();
    }

    public Map<Integer, Integer> checkWinning(List<Lotto> lottos) {
        return winningChecker.checkWinning(lottos, winner.getWinner());
    }

    public String getResult() {
        return profitRate.getResult();
    }
}
