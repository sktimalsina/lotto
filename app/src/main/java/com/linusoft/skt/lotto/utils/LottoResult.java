package com.linusoft.skt.lotto.utils;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by sunil on 2016-11-11.
 */
public  class LottoResult {
    @SerializedName("draw_date")
    private String drawDate;
    private int num_1;
    private int num_2;
    private int num_3;
    private int num_4;
    private int num_5;
    private int num_6;
    private int num_bonus;


    public LottoResult(int num_1, int num_2, int num_3, int num_4, int num_5, int num_6, int num_bonus, String drawDate) {
        this.num_1 = num_1;
        this.num_2 = num_2;
        this.num_3 = num_3;
        this.num_4 = num_4;
        this.num_5 = num_5;
        this.num_6 = num_6;
        this.num_bonus = num_bonus;
        this.drawDate = drawDate;
    }

    public int getNum_1() {
        return num_1;
    }

    public void setNum_1(int num_1) {
        this.num_1 = num_1;
    }

    public int getNum_2() {
        return num_2;
    }

    public void setNum_2(int num_2) {
        this.num_2 = num_2;
    }

    public int getNum_3() {
        return num_3;
    }

    public void setNum_3(int num_3) {
        this.num_3 = num_3;
    }

    public int getNum_4() {
        return num_4;
    }

    public void setNum_4(int num_4) {
        this.num_4 = num_4;
    }

    public int getNum_5() {
        return num_5;
    }

    public void setNum_5(int num_5) {
        this.num_5 = num_5;
    }

    public int getNum_6() {
        return num_6;
    }

    public void setNum_6(int num_6) {
        this.num_6 = num_6;
    }

    public int getNum_bonus() {
        return num_bonus;
    }

    public void setNum_bonus(int num_bonus) {
        this.num_bonus = num_bonus;
    }

    public String getDrawDate() {
        return drawDate;
    }

    public void setDrawDate(String drawDate) {
        this.drawDate = drawDate;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "%s, %d", getWinningNumbers().toString(), getNum_bonus());
    }

    @NonNull
    public List<Integer> getWinningNumbers() {
        return Arrays.asList(num_1, num_2,num_3, num_4, num_5, num_6);
    }
}
