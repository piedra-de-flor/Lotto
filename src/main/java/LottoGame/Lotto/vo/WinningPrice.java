package LottoGame.Lotto.vo;

public enum WinningPrice {
    FORTH_PLACE(5000),
    THIRD_PLACE(50000),
    SECOND_PLACE(15000000),
    FIRST_PLACE(2000000000);

    public final int price;

    WinningPrice(int i) {
        this.price = i;
    }
}
