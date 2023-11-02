package LottoGame.Lotto.model;

import LottoGame.Lotto.vo.Lotto;
import LottoGame.Lotto.vo.Lottos;
import LottoGame.Lotto.vo.Numbers;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private static final int LOTTO_AMOUNT_INITIAL_COUNT = 0;
    private final Lottos lottos;
    private final LottoNumberMaker lottoNumberMaker;

    public LottoManager() {
        this.lottos = new Lottos(new ArrayList<>());
        this.lottoNumberMaker = new LottoNumberMakerImpl();
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }

    public void makeLottos(int lottoAmount) {
        for (int amount = LOTTO_AMOUNT_INITIAL_COUNT; amount < lottoAmount; amount++) {
            lottos.add(makeLotto());
        }
    }

    public void makeManualLottos(List<Integer> numbers) {
        lottos.add(new Lotto(numbers));
    }

    private Lotto makeLotto() {
        List<Integer> lottoNumbers = lottoNumberMaker.makeLottoNumbers();
        return new Lotto(lottoNumbers);
    }
}