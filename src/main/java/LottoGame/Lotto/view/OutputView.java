package LottoGame.Lotto.view;

import LottoGame.Lotto.vo.Lotto;
import LottoGame.Lotto.vo.WinningPrice;
import LottoGame.Lotto.vo.WinningsCount;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final OutputView OUTPUT_VIEW = new OutputView();
    private OutputView() {
    }
    public static OutputView getInstance() {
        return OUTPUT_VIEW;
    }

    public void printInputMoneyMassage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printAmountLottos(int lottos) {
        System.out.println(lottos + "개를 구매했습니다.");
    }

    public void printEachLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void printWinnerMassage() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printResultMassage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("----------");
    }

    public void printResult(Map<Integer, Integer> result) {
        for (WinningsCount winningsCount : WinningsCount.values()) {
            int correctCount = winningsCount.correctCount;
            WinningPrice winningPrice = WinningPrice.valueOf(winningsCount.name());

            System.out.println(correctCount + "개 일치 (" + winningPrice.price + "원) - " + result.get(correctCount) + "개");
        }
    }


    public void printProfit(double profit, String result) {
        System.out.println("총 수익률은 " + profit + "입니다. (기준이 1이기 때문에 결과적으로 " + result + "라는 의미임)");
    }
}
