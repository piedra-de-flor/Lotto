package LottoGame.Lotto.model;

import LottoGame.Lotto.vo.LottoNumberBoundary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoNumberMakerImpl implements LottoNumberMaker {
    private static final int LOTTO_NUMBER_RANGE = 6;
    @Override
    public List<Integer> makeLottoNumbers() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        while (numbers.size() < LOTTO_NUMBER_RANGE) {
            int randomNumber = random.nextInt(LottoNumberBoundary.MAX_NUMBER.number) + LottoNumberBoundary.MIN_NUMBER.number;

            add(numbers, randomNumber);
        }

        return numbers;
    }

    private void add(List<Integer> numbers, int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
