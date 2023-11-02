package LottoGame.Lotto.model;

import LottoGame.Lotto.vo.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinnerManager {
    private final WinningChecker winningChecker;
    private Winner winner;
    private BonusBall bonus;
    private ProfitRate profitRate;

    public WinnerManager() {
        this.winningChecker = new WinningChecker(new HashMap<>());
    }

    public void makeNewWinner(List<Integer> numbers) {
        this.winner = new Winner(numbers);
    }

    public void makeBonusBall(String number) {
        this.bonus = new BonusBall(number, this.winner);
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

    public Map<WinningsCount, Integer> checkWinning(List<Lotto> lottos) {
        return winningChecker.checkWinning(lottos, winner.getWinner(), this.bonus.getNumber());
    }

    public String getResult() {
        return profitRate.getResult();
    }
}