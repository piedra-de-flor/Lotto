package LottoGame.Lotto.vo;

public class Money {
    private static final int ZERO_FOR_CHECK_MONEY_IS_FIT = 0;
    private final int lottoPrice;
    private final int value;
    public Money(String input, int lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.value = validateInput(input);
    }

    public int getValue() {
        return value;
    }

    private int validateInput(String input) {
        int value;
        value = isNumber(input);

        if (!isValidMoney(value)) {
            throw new IllegalArgumentException("CHECK YOUR INPUT {It has to over lotto price and Perfectly divided by lotto price");
        }

        return value;
    }

    private int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("input must Integer");
        }
    }

    private boolean isValidMoney(int money) {
        return money > lottoPrice && (money % lottoPrice == ZERO_FOR_CHECK_MONEY_IS_FIT);
    }
}