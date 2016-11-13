package com.linusoft.skt.lotto.utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.linusoft.skt.lotto.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

/**
 * Created by sktim on 11/12/2016.
 */

public class ResultParser {
    public LottoResults generateResult(Context context) {
        InputStream raw = context.getResources().openRawResource(R.raw.lotto649results);
        Reader reader = new BufferedReader(new InputStreamReader(raw));
        Gson gson = new GsonBuilder().create();
        Type collectionType = new TypeToken<Collection<LottoResult>>(){}.getType();
        List<LottoResult> results = gson.fromJson(reader, collectionType);
        return new LottoResults(results);
    }
}

