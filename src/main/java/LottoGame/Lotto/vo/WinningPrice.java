package LottoGame.Lotto.vo;

public enum WinningPrice {
    FORTH_PRICE(5000),
    THIRD_PRICE(50000),
    SECOND_PRICE(15000000),
    FIRST_PRICE(2000000000);

    public final int price;

    WinningPrice(int i) {
        this.price = i;
    }
}
