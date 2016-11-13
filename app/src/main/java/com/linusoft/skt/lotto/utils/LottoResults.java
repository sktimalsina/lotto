package com.linusoft.skt.lotto.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by sktim on 11/12/2016.
 */
public class LottoResults {
    @NonNull
    private Map<Date, LottoResult> lottoResults = new HashMap<>();

    public LottoResults(List<LottoResult> results) {
        for(LottoResult result : results) {
            String drawDate = result.getDrawDate();
            DateFormat format = new SimpleDateFormat("E, MMM d, yyyy", Locale.CANADA);
            try {
                Date date = format.parse(drawDate);
                lottoResults.put(date,result);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Nullable
    public LottoResult getResult(Date date) {
        return lottoResults.get(date);
    }
}
