package com.linusoft.skt.lotto.utils;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseIntArray;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
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
    private static int[] topTenNumbersDrawnSoFar;

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
        generatePositionalData();
        generateTopTenNumbersDrawnSoFar();
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

    public int[][] getTopTenNumbersDrawnByPosition() {
        int topTen[][] = new int[6][10];
        for (int j = 0; j < 6; j++) {
            topTen[j] = positionData[j].getSortedFrequencyCount(10);
        }
        return topTen;
    }

    public void generatePositionalData() {
        for (int i = 0; i < 6; i++) {
            SparseIntArray positionFrequencyCount = new SparseIntArray(49);
            for (LottoResult result : rawResults) {
                int winningNumber = result.getWinningNumbers().get(i);
                positionFrequencyCount.put(winningNumber, positionFrequencyCount.get(winningNumber) + 1);
            }
            positionData[i] = new PositionData(i);
            positionData[i].setFrequencyCount(positionFrequencyCount);
        }
    }
    private void generateTopTenNumbersDrawnSoFar() {
        SparseIntArray topNumbers = new SparseIntArray(49);
        for (LottoResult result : rawResults) {
            List<Integer> winningNumbers = result.getWinningNumbers();
            for (int i = 0; i < winningNumbers.size(); i++) {
                Integer currentNumber = winningNumbers.get(i);
                int currentCount = topNumbers.get(currentNumber);
                topNumbers.put(currentNumber, currentCount + 1);
            }
        }
        PositionData numbers = new PositionData(0);
        numbers.setFrequencyCount(topNumbers);
        topTenNumbersDrawnSoFar = numbers.getSortedFrequencyCount(10);
    }

    public int[] getTopTenNumbersDrawnSoFar() {
        return topTenNumbersDrawnSoFar;
    }

    private class PositionData {
        int positionNumber;
        SparseIntArray frequencyCount = new SparseIntArray();

        PositionData(int positionNumber) {
            this.positionNumber = positionNumber;
        }

        SparseIntArray getFrequencyCount() {
            return frequencyCount;
        }

        void setFrequencyCount(SparseIntArray positionFrequencyCount) {
            for (int i = 1; i < 49; i++) {
                frequencyCount.put(positionFrequencyCount.get(i), i);
            }
        }

        public int[] getSortedFrequencyCount(int depth) {
            int totalNumbers = frequencyCount.size();
            int sortedFrequency[] = new int[depth];
            for (int i = 0; i < depth; i++) {
                sortedFrequency[i] = frequencyCount.valueAt(totalNumbers - i - 1);
            }
            return sortedFrequency;
        }

    }
}
