package com.linusoft.skt.lotto;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.linusoft.skt.lotto.databinding.ActivityMainBinding;
import com.linusoft.skt.lotto.utils.LottoResult;
import com.linusoft.skt.lotto.utils.LottoResults;
import com.linusoft.skt.lotto.utils.ResultGenerator;
import com.linusoft.skt.lotto.utils.TicketGenerator;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        generateLottoResults();
        setupView();
    }

    private void setupView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.ticketList.setLayoutManager(new LinearLayoutManager(this));
        final LottoResultAdapter lottoResultAdapter = new LottoResultAdapter();
        binding.ticketList.setAdapter(lottoResultAdapter);
        binding.generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberOfResults = NumberUtils.toInt(binding.numberOfTicketsInput.getText().toString(), 1);
                lottoResultAdapter.setLottoResults(getLottoResults(numberOfResults));
            }
        });
    }

    @NonNull
    private List<LottoResult> getLottoResults(int numberOfResults) {
        List<LottoResult> results = new ArrayList<>();
        for (int i = 0; i < numberOfResults; i++) {
            results.add(new TicketGenerator().generateTicket(binding.sumCheck.isChecked(),
                    binding.primeCheck.isChecked(),
                    binding.includeTopPicks.isChecked(),
                    binding.includeLastDrawCheck.isChecked(),
                    binding.oddEvenCheck.isChecked()
            ));
        }
        return results;
    }

    private void generateLottoResults() {
        ResultGenerator resultGenerator = new ResultGenerator();
        resultGenerator.generateResult(this);
    }
}
