package com.linusoft.skt.lotto.utils;

import android.support.annotation.NonNull;
import android.support.v4.util.Pair;
import android.util.SparseIntArray;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sunil on 2016-12-03.
 */

public class TicketGenerator {
    public static List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
    private int sum = 0, oddCount = 0;
    private static List<Pair<Integer, Integer>> frequencyRanges = Arrays.asList(new Pair<>(1, 13),
            new Pair<>(3, 23),
            new Pair<>(10, 33),
            new Pair<>(28, 40),
            new Pair<>(27, 46),
            new Pair<>(38, 49),
            new Pair<>(1, 49)
    );

    public LottoResult generateTicket() {
        return new LottoResult(getGeneralValidResult());
    }

    public LottoResult generateTicket(boolean sumCheck, boolean primeCheck, boolean topPicksCheck, boolean lastDrawCheck, boolean oddCheck) {
        SparseIntArray lottoResult = getPositionFrequencyResult();
        while ((sumCheck && (sum >= 120 && sum <= 200))
                && (primeCheck && hasPrime(lottoResult))
                && (topPicksCheck && hasAtLeastOneTopTenFrequentNumber(lottoResult))
                && (oddCheck && (oddCount >= 2 || oddCount <= 4))) {
            lottoResult = getPositionFrequencyResult();
        }
        return new LottoResult(lottoResult);
    }

    @NonNull
    private SparseIntArray getGeneralValidResult() {
        SparseIntArray lottoResult = getPositionFrequencyResult();
        while (sum >= 120
                && sum <= 200
                && hasPrime(lottoResult)
                && hasAtLeastOneTopTenFrequentNumber(lottoResult)
                && (oddCount >= 2 || oddCount <= 4)) {
            lottoResult = getPositionFrequencyResult();
        }
        return lottoResult;
    }

    @NonNull
    private SparseIntArray getPositionFrequencyResult() {
        //Numbers based on position frequency
        SparseIntArray ticketNumbers = new SparseIntArray();
        int sum = 0, oddcount = 0;
        while (ticketNumbers.size() <= 6) {
            Pair<Integer, Integer> range = frequencyRanges.get(ticketNumbers.size());
            int candidate = getNumberInRange(range);
            if (ticketNumbers.indexOfValue(candidate) == -1) {
                ticketNumbers.put(ticketNumbers.size(), candidate);
                sum += candidate;
                oddcount = candidate % 2 == 0 ? oddcount : oddcount + 1;
            }
        }
        this.sum = sum;
        this.oddCount = oddcount;
        return ticketNumbers;
    }

    private int getNumberInRange(Pair<Integer, Integer> range) {
        int difference = (int) range.second - range.first;
        return (int) ((Math.random() * 100) % difference + range.first);
    }

    private boolean hasPrime(SparseIntArray result) {
        for (int prime :
                primes) {
            if (result.indexOfValue(prime) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean hasAtLeastOneTopTenFrequentNumber(SparseIntArray result) {
        int[] topTenDraws = LottoResults.getInstance().getTopTenNumbersDrawnSoFar();
        for (int draw : topTenDraws) {
            if (result.indexOfValue(draw) != -1) {
                return true;
            }
        }
        return false;
    }
}
