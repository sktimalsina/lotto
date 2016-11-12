package com.linusoft.skt.lotto.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sunil on 2016-11-11.
 */
public class Lotto649Stats {
    /**
     * Copied from <a href=http://www.lotto649stats.com/top-numbers.html>Top Numbers</a>
     */

    static List<List<Integer>> topTenNumbersDrawnByPosition;

    static {
        List<List<Integer>> data = new ArrayList<>();
        data.add(Arrays.asList(1, 12, 22, 31, 38, 49));
        data.add(Arrays.asList(2, 8, 23, 27, 41, 47));
        data.add(Arrays.asList(4, 10, 20, 34, 40, 48));
        data.add(Arrays.asList(3, 9, 19, 33, 43, 46));
        data.add(Arrays.asList(5, 7, 25, 32, 37, 45));
        data.add(Arrays.asList(7, 13, 21, 28, 34, 44));
        data.add(Arrays.asList(6, 15, 24, 30, 39, 43));
        data.add(Arrays.asList(8, 14, 17, 26, 42, 42));
        data.add(Arrays.asList(9, 11, 18, 29, 35, 40));
        data.add(Arrays.asList(10, 17, 16, 25, 36, 41));
        topTenNumbersDrawnByPosition = data;
    }

    static List<List<Integer>> topTenNumbersDrawnByPositionLast365Days;

    static {
        List<List<Integer>> data = new ArrayList<>();
        data.add(Arrays.asList(4,	8,	22,	39,	38,	47));
        data.add(Arrays.asList(7,	5,	25,	33,	39,	48));
        data.add(Arrays.asList(6,	7,	17,	37,	41,	44));
        data.add(Arrays.asList(1,	11,	30,	32,	42,	49));
        data.add(Arrays.asList(2,	16,	26,	36,	35,	43));
        data.add(Arrays.asList(3,	10,	28,	27,	37,	46));
        data.add(Arrays.asList(8,	15,	33,	29,	43,	42));
        data.add(Arrays.asList(5,	21,	34,	30,	36,	45));
        data.add(Arrays.asList(14,	12,	20,	31,	40,	36));
        data.add(Arrays.asList(9,	13,	21,	23,	45,	41));
        topTenNumbersDrawnByPositionLast365Days = data;
    }


}
