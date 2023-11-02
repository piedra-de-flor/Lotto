package LottoGame.Lotto.view;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);
    private static final InputView INPUT_VIEW = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return INPUT_VIEW;
    }

    public String inputMoney() {
        return scanner.nextLine();
    }

    public String inputManualLottoAmount() {
        return scanner.nextLine();
    }

    public String inputManualLottoNumbers() {
        return scanner.nextLine();
    }

    public String inputWinnerNumbers() {
        return scanner.nextLine();
    }

    public String inputBonusNumber() {return scanner.nextLine();}
}
