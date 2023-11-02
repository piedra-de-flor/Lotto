package LottoGame.Lotto.vo;

import java.util.List;

public class Lotto {
    private final Numbers numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers.getNumbers();
    }
}
