package com.linusoft.skt.lotto.utils;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunil on 2016-11-11.
 */
public class LottoResult {
    private final int year;
    private final int month;
    private final int day;

    @NonNull
    List<Integer> numbers = new ArrayList<>();

    public LottoResult(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;

        for (int i = 1; i <= 6; i++) {
            numbers.add(i);
        }
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
