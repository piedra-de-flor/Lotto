package LottoGame.Lotto;

import LottoGame.Lotto.model.LottoNumberMaker;
import LottoGame.Lotto.model.LottoNumberMakerImpl;
import LottoGame.Lotto.vo.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomNumberTest {
    @DisplayName("lotto's number's ascending order test")
    @Test
    void 오름차순_테스트() {
        LottoNumberMaker lottoNumberMaker = new LottoNumberMakerImpl();

        List<Integer> originNumbers = lottoNumberMaker.makeLottoNumbers();
        int min = originNumbers.get(0);
        Numbers numbers = new Numbers(originNumbers);

        assertThat(min).isNotEqualTo(numbers.getNumbers().get(0));

        Collections.sort(originNumbers);
        min = originNumbers.get(0);

        assertThat(min).isEqualTo(numbers.getNumbers().get(0));
    }
}
