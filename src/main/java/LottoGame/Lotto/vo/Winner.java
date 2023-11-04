
package LottoGame.Lotto.vo;

import java.util.List;

public class Winner {
    private final List<Integer> winner;

    public Winner(List<Integer> numbers) {
        this.winner = numbers;
    }

    public List<Integer> getWinner() {
        return winner;
    }
}