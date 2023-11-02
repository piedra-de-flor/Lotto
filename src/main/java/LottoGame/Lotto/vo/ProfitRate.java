package LottoGame.Lotto.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitRate {
    private static final String PROFIT = "이득";
    private static final String LOSS = "손해";
    private static final int BREAK_EVEN_POINT_RATE = 1;
    private static final int NO_PROFIT_RATE = 0;
    private static final int RATE_MAXIMUM_DECIMAL_POINT = 1;
    private final double profitRate;

    public ProfitRate(int money, int price) {
        this.profitRate = calculate(money, price);
    }

    public double calculate(int money, int price) {
        if (price != NO_PROFIT_RATE) {
            double result = (double) price / (double) money;
            BigDecimal realRate = new BigDecimal(String.valueOf(result));
            return realRate.setScale(RATE_MAXIMUM_DECIMAL_POINT, RoundingMode.HALF_UP).doubleValue();
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
