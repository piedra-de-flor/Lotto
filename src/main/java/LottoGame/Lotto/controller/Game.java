package LottoGame.Lotto.controller;

import LottoGame.Lotto.model.LottoManager;
import LottoGame.Lotto.model.WinnerManager;
import LottoGame.Lotto.view.InputView;
import LottoGame.Lotto.view.OutputView;
import LottoGame.Lotto.vo.InputManualAmount;
import LottoGame.Lotto.vo.InputNumbers;
import LottoGame.Lotto.vo.Money;

public class Game {
    private static final int LOTTO_PRICE = 1000;
    private static final int INITIAL_MANUAL_LOTTO_INDEX = 0;
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
        int manualLottoAmount = manualPurchase(lottoAmount);

        OutputView.getInstance().printAmountLottos(manualLottoAmount, lottoAmount - manualLottoAmount);

        lottoManager.makeLottos(lottoAmount - manualLottoAmount);
        OutputView.getInstance().printEachLotto(lottoManager.getLottos());
    }

    private int manualPurchase(int lottoAmount) {
        OutputView.getInstance().printInputManualLottoAmount();
        InputManualAmount inputManualAmount = new InputManualAmount(InputView.getInstance().inputManualLottoAmount(), lottoAmount);
        int manualLottoAmount = inputManualAmount.getAmount();

        OutputView.getInstance().printInputManualLottoNumbers();
        for (int i = INITIAL_MANUAL_LOTTO_INDEX; i < manualLottoAmount; i++) {
            InputNumbers inputNumbers = new InputNumbers(InputView.getInstance().inputManualLottoNumbers());
            lottoManager.makeManualLottos(inputNumbers.getNumbers());
        }

        return manualLottoAmount;
    }

    private void makeWinnerNumbers() {
        OutputView.getInstance().printWinnerMassage();
        InputNumbers inputNumbers = new InputNumbers(InputView.getInstance().inputWinnerNumbers());
        winnerManager.makeNewWinner(inputNumbers.getNumbers());

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
