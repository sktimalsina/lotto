package com.linusoft.skt.lotto;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.linusoft.skt.lotto.utils.LottoResult;
import com.linusoft.skt.lotto.utils.LottoResults;
import com.linusoft.skt.lotto.utils.ResultGenerator;

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
        assertEquals("{0=1, 1=12, 2=22, 3=31, 4=38, 5=49}",
                LottoResults.getInstance().getTopTenNumbersDrawnByPosition().toString());
    }

}