package LottoGame.Lotto.controller;

import LottoGame.Lotto.model.LottoManager;
import LottoGame.Lotto.model.WinnerManager;
import LottoGame.Lotto.view.InputView;
import LottoGame.Lotto.view.OutputView;
import LottoGame.Lotto.vo.Money;

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
        int lottoAmount = money.getValue() / LOTTO_PRICE;

        OutputView.getInstance().printAmountLottos(lottoAmount);

        lottoManager.makeLottos(lottoAmount);
        OutputView.getInstance().printEachLotto(lottoManager.getLottos());
    }

    private void makeWinnerNumbers() {
        OutputView.getInstance().printWinnerMassage();
        winnerManager.makeNewWinner(InputView.getInstance().inputWinnerNumbers());
        OutputView.getInstance().printBonusWinnerMassage();
        winnerManager.makeBonusBall(InputView.getInstance().inputBonusNumber());
    }

    private void showResult() {
        OutputView.getInstance().printResultMassage();
        OutputView.getInstance().printResult(winnerManager.checkWinning(lottoManager.getLottos()));

        double profit = winnerManager.calculateProfit(money, lottoManager.getLottos());
        OutputView.getInstance().printProfit(profit, winnerManager.getResult());
    }
}