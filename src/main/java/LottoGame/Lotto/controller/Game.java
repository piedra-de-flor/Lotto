package LottoGame.Lotto.controller;

import LottoGame.Lotto.model.LottoManager;
import LottoGame.Lotto.model.WinnerManager;
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
    private final WinnerManager winnerManager;
    private Money money;

    public Game() {
        this.lottoManager = new LottoManager();
        this.winnerManager = new WinnerManager();
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
        winnerManager.makeNewWinner(InputView.getInstance().inputWinnerNumbers());
    }

    private void showResult() {
        OutputView.getInstance().printResultMassage();
        OutputView.getInstance().printResult(winnerManager.checkWinning(lottoManager.getLottos()));

        double profit = winnerManager.calculateProfit(money, lottoManager.getLottos());
        OutputView.getInstance().printProfit(profit, winnerManager.getResult());
    }
}
