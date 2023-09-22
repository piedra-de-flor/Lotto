package LottoGame.Lotto.vo;

import java.util.Map;

public class Winnings {
    private static final int INITIAL_CORRECT_AMOUNT = 0;
    private static final int INITIAL_WINNING_PRICE = 0;
    private final Map<Integer, Integer> winnings;

    public Winnings(Map<Integer, Integer> winnings) {
        this.winnings = formatWinningsForm(winnings);
    }

    public Map<Integer, Integer> getWinnings() {
        return winnings;
    }

    private Map<Integer, Integer> formatWinningsForm(Map<Integer, Integer> winning) {
        winning.put(WinningsCount.FORTH_PLACE.correctCount, INITIAL_CORRECT_AMOUNT);
        winning.put(WinningsCount.THIRD_PLACE.correctCount, INITIAL_CORRECT_AMOUNT);
        winning.put(WinningsCount.SECOND_PLACE.correctCount, INITIAL_CORRECT_AMOUNT);
        winning.put(WinningsCount.FIRST_PLACE.correctCount, INITIAL_CORRECT_AMOUNT);

        return winning;
    }

    public void add(int correctCount) {
        if (correctCount >= WinningsCount.FORTH_PLACE.correctCount) {
            plusValue(correctCount);
        }
    }

    private void plusValue(int correctCount) {
        int beforeValue = winnings.get(correctCount);
        winnings.replace(correctCount, ++beforeValue);
    }

    public int getWinningPrice() {
        int totalPrice = INITIAL_WINNING_PRICE;
        totalPrice += winnings.get(WinningsCount.FORTH_PLACE.correctCount) * WinningPrice.FORTH_PRICE.price;
        totalPrice += winnings.get(WinningsCount.THIRD_PLACE.correctCount) * WinningPrice.THIRD_PRICE.price;
        totalPrice += winnings.get(WinningsCount.SECOND_PLACE.correctCount) * WinningPrice.SECOND_PRICE.price;
        totalPrice += winnings.get(WinningsCount.FORTH_PLACE.correctCount) * WinningPrice.FIRST_PRICE.price;

        return totalPrice;
    }
}
