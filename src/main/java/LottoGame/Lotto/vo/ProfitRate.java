package LottoGame.Lotto.vo;

public class ProfitRate {
    private static final int BREAK_EVEN_POINT_RATE = 1;
    private final double profitRate;

    public ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public boolean isProfit() {
        return profitRate > BREAK_EVEN_POINT_RATE;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
