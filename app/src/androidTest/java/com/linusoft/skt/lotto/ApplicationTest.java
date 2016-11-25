package com.linusoft.skt.lotto;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.linusoft.skt.lotto.utils.LottoResult;
import com.linusoft.skt.lotto.utils.LottoResults;
import com.linusoft.skt.lotto.utils.ResultGenerator;

import java.util.Arrays;
import java.util.GregorianCalendar;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ResultGenerator resultGenerator = new ResultGenerator();
        resultGenerator.generateResult(getSystemContext());
    }

    public void testLottoResultGivenDateReturnsResult() {
        LottoResult lottoResult = LottoResults.getInstance().getResult(new GregorianCalendar(2016, 10, 9).getTime());
        assertNotNull(lottoResult);
        assertEquals(lottoResult.toString(), "[6, 9, 30, 37, 43, 49], 18");
    }

    public void testLottoResultGivesTopTenNumbersByPosition() {
        assertEquals("[[1, 2, 4, 3, 5, 7, 6, 9, 8, 10], [12, 8, 10, 9, 15, 13, 14, 11, 17, 6], [22, 23, 20, 25, 21, 24, 17, 18, 16, 26], [31, 27, 34, 33, 32, 26, 28, 30, 29, 25], [38, 40, 41, 43, 37, 34, 39, 42, 35, 36], [47, 48, 46, 45, 44, 43, 42, 41, 40, 39]]",
                Arrays.deepToString(LottoResults.getInstance().getTopTenNumbersDrawnByPosition()));
    }

}