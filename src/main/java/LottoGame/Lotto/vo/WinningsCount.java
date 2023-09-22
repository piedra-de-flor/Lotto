package LottoGame.Lotto.vo;

public enum WinningsCount {
    FORTH_PLACE(3),
    THIRD_PLACE(4),
    SECOND_PLACE(5),
    FIRST_PLACE(6);

    public final int correctCount;

    WinningsCount(int i) {
        this.correctCount = i;
    }
}
