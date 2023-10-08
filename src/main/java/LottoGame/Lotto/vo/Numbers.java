package LottoGame.Lotto.vo;

import java.util.Collections;
import java.util.List;

public class Numbers {
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
        changeNumbersToAscendingOrder();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void changeNumbersToAscendingOrder() {
        Collections.sort(this.numbers);
    }
}