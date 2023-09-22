package LottoGame.Lotto.controller;

import LottoGame.Lotto.model.LottoManager;
import LottoGame.Lotto.model.WinningChecker;
import LottoGame.Lotto.view.InputView;
import LottoGame.Lotto.view.OutputView;
import LottoGame.Lotto.vo.Money;
import LottoGame.Lotto.vo.ProfitRate;
import LottoGame.Lotto.vo.Winner;

import java.util.HashMap;

public class Game {
    private static final int LOTTO_PRICE = 1000;
    private final LottoManager lottoManager;
    private final WinningChecker winningChecker;
    private Winner winner;
    private Money money;

    public Game() {
        this.lottoManager = new LottoManager();
        this.winningChecker = new WinningChecker(new HashMap<>());
    }

    public void start() {
        purchase();
        makeWinnerNumbers();
        showResult();
    }

    private void purchase() {
        OutputView.getInstance().printInputMoneyMassage();
        money = new Money(InputView.getInstance().inputMoney(), LOTTO_PRICE);
        int lottoAmount = money.getMoney() / LOTTO_PRICE;

        OutputView.getInstance().printAmountLottos(lottoAmount);

        lottoManager.makeLottos(lottoAmount);
        OutputView.getInstance().printEachLotto(lottoManager.getLottos());
    }

    private void makeWinnerNumbers() {
        OutputView.getInstance().printWinnerMassage();
        winner = new Winner(InputView.getInstance().inputWinnerNumbers());
    }

    private void showResult() {
        OutputView.getInstance().printResultMassage();
        winningChecker.checkWinning(lottoManager.getLottos(), winner.getWinner());
        OutputView.getInstance().printResult(winningChecker.getWinnings());

        ProfitRate profit = new ProfitRate(winningChecker.calculateProfit(money));

        if (profit.isProfit()) {
            OutputView.getInstance().printProfit(profit.getProfitRate());
        } else {
            OutputView.getInstance().printLoss(profit.getProfitRate());
        }
    }
}
