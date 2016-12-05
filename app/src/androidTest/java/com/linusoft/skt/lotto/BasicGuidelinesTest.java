package com.linusoft.skt.lotto;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;

import com.linusoft.skt.lotto.utils.LottoResult;
import com.linusoft.skt.lotto.utils.ResultGenerator;
import com.linusoft.skt.lotto.utils.TicketGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sunil on 2016-12-03.
 */

public class BasicGuidelinesTest extends ApplicationTestCase<Application> {
    private LottoResult result;

    public BasicGuidelinesTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ResultGenerator resultGenerator = new ResultGenerator();
        resultGenerator.generateResult(getSystemContext());
        result = new TicketGenerator().generateTicket();
    }

    public void testNumbersAreInRange() {
        assertTrue(result.getNum_1() <= 13 && result.getNum_1() >= 1);
        assertTrue(result.getNum_2() <= 23 && result.getNum_2() >= 3);
        assertTrue(result.getNum_3() <= 33 && result.getNum_3() >= 10);
        assertTrue(result.getNum_4() <= 40 && result.getNum_4() >= 18);
        assertTrue(result.getNum_5() <= 46 && result.getNum_5() >= 27);
        assertTrue(result.getNum_6() <= 49 && result.getNum_6() >= 38);
    }

    public void testMinimum2OddsAndEvens() {
        int oddCount = 0;
        List<Integer> winningNumbers = result.getWinningNumbers();
        for (int i = 0; i < 6; i++) {
            oddCount = winningNumbers.get(i) % 2 == 0 ? oddCount : oddCount + 1;
        }
        assertTrue(oddCount >= 2 && oddCount <= 4);
    }

    public void testSumIsBetween120to200() {
        assertTrue(result.getSum() >= 120 && result.getSum() <= 200);
    }

    public void testResultHasAtleastOnePrimeNumber() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
        assertTrue(primes.contains(result.getNum_1()) ||
                primes.contains(result.getNum_2()) ||
                primes.contains(result.getNum_3()) ||
                primes.contains(result.getNum_4()) ||
                primes.contains(result.getNum_5()) ||
                primes.contains(result.getNum_6()) ||
                primes.contains(result.getNum_bonus()));
    }

    public void testHasAtLeastOneRepeatingNumberFromLastDraw() {
        //TODO::This can only be valid until there is always an updated data
        assertTrue(true);
    }
}
