package LottoGame.Lotto.vo;

public class Money {
    private static final int ZERO_FOR_CHECK_MONEY_IS_FIT = 0;
    private final int lottoPrice;
    private final int money;
    public Money(String input, int lottoPrice) {
        this.lottoPrice = lottoPrice;
        this.money = validateInput(input);
    }

    public int getMoney() {
        return money;
    }

    private int validateInput(String input) {
        int money;
        money = isNumber(input);

        if (!isValidMoney(money)) {
            throw new IllegalArgumentException("CHECK YOUR INPUT {It has to over lotto price and Perfectly divided by lotto price");
        }

        return money;
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
