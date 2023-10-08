package LottoGame.Lotto.vo;

import java.util.List;
import java.util.Optional;

public class BonusBall{
    private final int number;
    public BonusBall(String number, Winner winner) {
        this.number = validateNumber(number, winner.getWinner());
    }

    public int getNumber() {
        return number;
    }

    private int validateNumber(String number, List<Integer> winner) {
        if (isNumber(number) && isInBoundary(number) && isNoDuplication(number, winner)) {
            return Integer.parseInt(number);
        }
        throw new IllegalArgumentException("Wrong Bonus Ball Number");
    }

    private boolean isNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isInBoundary(String input) {
        int number = Integer.parseInt(input);
        return LottoNumberBoundary.MIN_NUMBER.number <= number && LottoNumberBoundary.MAX_NUMBER.number >= number;
    }

    private boolean isNoDuplication(String input, List<Integer> winner) {
        Optional<Integer> duplicationNumber = winner.stream()
                .filter(integer -> integer.equals(Integer.parseInt(input)))
                .findAny();

        return duplicationNumber.isEmpty();
    }
}