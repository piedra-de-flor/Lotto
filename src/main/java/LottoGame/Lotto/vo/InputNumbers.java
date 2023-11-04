package LottoGame.Lotto.vo;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputNumbers {
    private final List<Integer> numbers;

    public InputNumbers(String input) {
        this.numbers = validateInput(input);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> validateInput(String input) {
        String[] inputNumbers = input.split(",");
        List<Integer> numbers = isNumber(inputNumbers);

        if (isInBoundary(numbers) && isNoDuplication(numbers)) {
            changeNumbersToAscendingOrder(numbers);
            return numbers;
        }
        throw new IllegalArgumentException("not valid Input (manual)");
    }

    private List<Integer> isNumber(String[] numbers) {
        try {
            return Stream.of(numbers)
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("numbers must Integers");
        }
    }

    private boolean isNoDuplication(List<Integer> numbers) {
        int beforeDeleteDuplication = numbers.size();
        List<Integer> numbersAfterDeleteDuplication = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        int afterDeleteDuplication = numbersAfterDeleteDuplication.size();

        return beforeDeleteDuplication == afterDeleteDuplication;
    }

    private boolean isInBoundary(List<Integer> numbers) {
        Optional<Integer> min = numbers.stream().min(Integer::compareTo);
        Optional<Integer> max = numbers.stream().max(Integer::compareTo);

        if (min.isPresent()) {
            return min.get() >= LottoNumberBoundary.MIN_NUMBER.number && max.get() <= LottoNumberBoundary.MAX_NUMBER.number;
        }
        throw new IllegalArgumentException("no valid boundary Input");
    }

    private void changeNumbersToAscendingOrder(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
