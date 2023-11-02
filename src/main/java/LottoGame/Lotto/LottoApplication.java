package LottoGame.Lotto;

import LottoGame.Lotto.controller.Game;

public class LottoApplication {
	public static void main(String[] args) {
		//SpringApplication.run(LottoApplication.class, args);
		Game lottoGame = new Game();
		lottoGame.start();
	}

}
