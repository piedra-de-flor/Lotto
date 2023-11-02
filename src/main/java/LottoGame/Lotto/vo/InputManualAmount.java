package LottoGame.Lotto.vo;

public class InputManualAmount {
    private final int amount;

    public InputManualAmount(String input, int autoAmount) {
        this.amount = validateAmount(input, autoAmount);
    }

    private int validateAmount(String input, int autoAmount) {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("not valid input");
        }

        if (!isInBoundary(amount, autoAmount)) {
            throw new IllegalArgumentException("input must be bigger than 0, smaller than autoAmount");
        }
        return amount;
    }

    private boolean isInBoundary(int manual, int auto) {
        return manual >= 0 && manual <= auto;
    }

    public int getAmount() {
        return amount;
    }
}
