package com.linusoft.skt.lotto;

import android.app.Application;
import android.test.ApplicationTestCase;

import com.linusoft.skt.lotto.utils.LottoResult;
import com.linusoft.skt.lotto.utils.LottoResults;
import com.linusoft.skt.lotto.utils.ResultParser;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    private LottoResults sut;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ResultParser resultParser = new ResultParser();
        sut = resultParser.generateResult(getSystemContext());
    }

    public void testLottoResultGivenDateReturnsResult() {
       LottoResult lottoResult = sut.getResult(new GregorianCalendar(2016, 11, 9).getTime());
        assertNull(lottoResult);
        assertEquals(lottoResult.toString(), "[6, 9, 30, 37, 43, 49], 18");
    }
}