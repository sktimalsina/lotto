package com.linusoft.skt.lotto;

import android.os.Looper;
import android.test.mock.MockContext;

import com.linusoft.skt.lotto.utils.LottoResult;
import com.linusoft.skt.lotto.utils.LottoResults;
import com.linusoft.skt.lotto.utils.ResultParser;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class LottoResultsTest {
    private LottoResults lottoResults;

    @Before
    public void setup() {
        List<LottoResult> resultList = new ArrayList<>();
        resultList.add(new LottoResult(1, 2, 3, 4, 5, 6, 7, "Wed, Nov 9, 2016"));
        resultList.add(new LottoResult(11, 12, 13, 14, 15, 16, 17, "Thu, Nov 10, 2016"));
        lottoResults = new LottoResults(resultList);
    }

    @Test
    public void onSetup_lottoResults_setsCorrectDateAsKey() {
        assertThat(lottoResults.getResult(2016, 11, 9), notNullValue());
        assertThat(lottoResults.getItemCount(), equalTo(2));
    }

    @Test
    public void onSetup_lottoResults_savesObjects() {
        LottoResult result = lottoResults.getResult(2016, 11, 9);
        assertThat(result.getNum_1(), equalTo(1));
        assertThat(result.getNum_2(), equalTo(2));
        assertThat(result.getNum_3(), equalTo(3));
        assertThat(result.getNum_4(), equalTo(4));
        assertThat(result.getNum_5(), equalTo(5));
        assertThat(result.getNum_6(), equalTo(6));
        assertThat(result.getNum_bonus(), equalTo(7));
        assertThat(result.getDrawDate(), equalTo("Wed, Nov 9, 2016"));
    }
}