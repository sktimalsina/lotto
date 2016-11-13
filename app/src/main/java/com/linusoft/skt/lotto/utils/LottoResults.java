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
        for (LottoResult result : results) {
            String drawDate = result.getDrawDate();
            Date formattedDate = getFormattedDate(drawDate);
            if (formattedDate != null) {
                lottoResults.put(formattedDate, result);
            }
        }
    }

    @Nullable
    private Date getFormattedDate(String drawDate) {
        try {
            DateFormat format = new SimpleDateFormat("E, MMM d, yyyy", Locale.getDefault());
            return format.parse(drawDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Nullable
    public LottoResult getResult(Date date) {
        return lottoResults.get(date);
    }

    public LottoResult getResult(int year, int month, int day) {
        // Gregorian calendar months start from 0 to 11
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        return getResult(calendar.getTime());
    }

    public int getItemCount() {
        return lottoResults.size();
    }
}
