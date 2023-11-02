package LottoGame.Lotto.vo;

public enum WinningsCount {
    FIFTH_PLACE(3),
    FORTH_PLACE(4),
    THIRD_PLACE(5),
    SECOND_PLACE(5),
    FIRST_PLACE(6);

    public final int correctCount;

    WinningsCount(int i) {
        this.correctCount = i;
    }
}