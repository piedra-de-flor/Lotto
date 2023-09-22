package LottoGame.Lotto.vo;

public class ProfitRate {
    private static final String PROFIT = "이득";
    private static final String LOSS = "손해";
    private static final int BREAK_EVEN_POINT_RATE = 1;
    private static final int NO_PROFIT_RATE = 0;
    private final double profitRate;

    public ProfitRate(int money, int price) {
        this.profitRate = calculate(money, price);
    }

    public double calculate(int money, int price) {
        if (price != NO_PROFIT_RATE) {
            return money / price;
        }
        return NO_PROFIT_RATE;
    }

    public double getProfitRate() {
        return profitRate;
    }

    public String getResult() {
        if (profitRate > BREAK_EVEN_POINT_RATE) {
            return PROFIT;
        }
        return LOSS;
    }
}
