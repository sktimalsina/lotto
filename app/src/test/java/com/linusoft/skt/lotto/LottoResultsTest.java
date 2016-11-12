package com.linusoft.skt.lotto;

import com.linusoft.skt.lotto.utils.LottoResult;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class LottoResultsTest {
    private LottoResult lottoResult;

    @Test
    public void lottoResult_givenDate_givesResult() throws Exception {
        lottoResult = new LottoResult(2016, 10, 10);
        assertThat(lottoResult.toString(), equalTo("[1, 2, 3, 4, 5, 6]"));
    }
}