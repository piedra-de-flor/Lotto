package LottoGame.Lotto.vo;

import java.util.Arrays;
import java.util.Map;

public class Winnings {
    private static final int INITIAL_CORRECT_AMOUNT = 0;
    private static final int INITIAL_WINNING_PRICE = 0;
    private final Map<WinningsCount, Integer> winnings;

    public Winnings(Map<WinningsCount, Integer> winnings) {
        this.winnings = formatWinningsForm(winnings);
    }

    public Map<WinningsCount, Integer> getWinnings() {
        return winnings;
    }

    private Map<WinningsCount, Integer> formatWinningsForm(Map<WinningsCount, Integer> winning) {
        winning.put(WinningsCount.FIFTH_PLACE, INITIAL_CORRECT_AMOUNT);
        winning.put(WinningsCount.FORTH_PLACE, INITIAL_CORRECT_AMOUNT);
        winning.put(WinningsCount.THIRD_PLACE, INITIAL_CORRECT_AMOUNT);
        winning.put(WinningsCount.SECOND_PLACE, INITIAL_CORRECT_AMOUNT);
        winning.put(WinningsCount.FIRST_PLACE, INITIAL_CORRECT_AMOUNT);

        return winning;
    }


    public void recordInNotFiveCorrectCount(int correctCount) {
        if (correctCount >= WinningsCount.FIFTH_PLACE.correctCount) {
            int beforeValue;

            WinningsCount winningPlace = Arrays.stream(WinningsCount.values())
                    .filter(winningsCount -> winningsCount.correctCount == correctCount)
                    .findAny().get();

            beforeValue = winnings.get(winningPlace);
            winnings.put(winningPlace, ++beforeValue);
        }
    }

    public void recordInFiveCorrectCount(boolean isBonus) {
        int beforeValue;

        if (isBonus) {
            beforeValue = winnings.get(WinningsCount.SECOND_PLACE);
            winnings.put(WinningsCount.SECOND_PLACE, ++beforeValue);
            return;
        }

        beforeValue = winnings.get(WinningsCount.THIRD_PLACE);
        winnings.put(WinningsCount.THIRD_PLACE, ++beforeValue);
    }

    public int calculateWinningPrice() {
        int totalPrice = INITIAL_WINNING_PRICE;

        totalPrice += winnings.get(WinningsCount.FIFTH_PLACE) * WinningPrice.FIFTH_PLACE.price;
        totalPrice += winnings.get(WinningsCount.FORTH_PLACE) * WinningPrice.FORTH_PLACE.price;
        totalPrice += winnings.get(WinningsCount.THIRD_PLACE) * WinningPrice.THIRD_PLACE.price;
        totalPrice += winnings.get(WinningsCount.SECOND_PLACE) * WinningPrice.SECOND_PLACE.price;
        totalPrice += winnings.get(WinningsCount.FORTH_PLACE) * WinningPrice.FIRST_PLACE.price;

        return totalPrice;
    }
}