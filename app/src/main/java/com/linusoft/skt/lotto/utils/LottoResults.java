package com.linusoft.skt.lotto.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;

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
    private static LottoResults instance = new LottoResults();
    @NonNull
    private Map<Date, LottoResult> lottoResults = new HashMap<>();
    private static List<LottoResult> rawResults;
    private static PositionData[] positionData = new PositionData[6];

    private LottoResults() {
    }

    public void setData(List<LottoResult> results) {
        rawResults = results;
        for (LottoResult result : results) {
            String drawDate = result.getDrawDate();
            Date formattedDate = getFormattedDate(drawDate);
            if (formattedDate != null) {
                lottoResults.put(formattedDate, result);
            }
        }
    }

    public static LottoResults getInstance() {
        return (instance == null) ? new LottoResults() : instance;
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

    public SparseIntArray getTopTenNumbersDrawnByPosition() {
        SparseIntArray frequencyCount = new SparseIntArray();
        for (int i = 0; i < 6; i++) {
        }
        return frequencyCount;
    }

    public void generatePositionalData() {
        for (int i = 0; i < 6; i++) {
            SparseIntArray positionFrequencyCount = new SparseIntArray(50);
            for (LottoResult result : rawResults) {
                int winningNumber = result.getWinningNumbers().get(i);
                int count = positionFrequencyCount.get(winningNumber) + 1;
                positionFrequencyCount.put(winningNumber, count);
            }
            positionData[i] = new PositionData(i);
            positionData[i].setFrequencyCount(positionFrequencyCount);
        }
    }

    private class PositionData {
        int positionNumber;
        SparseIntArray frequencyCount = new SparseIntArray(49);

        PositionData(int positionNumber) {
            this.positionNumber = positionNumber;
        }

        public void setFrequencyCount(int winningNumber, int frequency) {
            frequencyCount.put(winningNumber, frequency);
        }

        public SparseIntArray getFrequencyCount() {
            return frequencyCount;
        }

        public int getPositionNumber() {
            return positionNumber;
        }

        public void setFrequencyCount(SparseIntArray positionFrequencyCount) {
            //swap SparseIntArray to get sorted vals
            for (int i =0; i < positionFrequencyCount.size(); i++) {
                this.frequencyCount.put(positionFrequencyCount.get(i), i);
            }
        }

    }
}
