package LottoGame.Lotto.vo;

public enum WinningPrice {
    FIFTH_PLACE(5000),
    FORTH_PLACE(50000),
    THIRD_PLACE(15000000),
    SECOND_PLACE(300000000),
    FIRST_PLACE(2000000000);

    public final int price;

    WinningPrice(int i) {
        this.price = i;
    }
}