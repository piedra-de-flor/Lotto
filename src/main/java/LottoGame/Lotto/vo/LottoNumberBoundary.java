package LottoGame.Lotto.vo;

public enum LottoNumberBoundary {
    MAX_NUMBER(45 ),
    MIN_NUMBER(1);

    public final int number;

    LottoNumberBoundary(int i) {
        this.number = i;
    }
}
