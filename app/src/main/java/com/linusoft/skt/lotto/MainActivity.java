package com.linusoft.skt.lotto;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.linusoft.skt.lotto.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recylcerView.setLayoutManager(new LinearLayoutManager(this));
        List<Beacon> beacons = new ArrayList<>();
        beacons.add(new Beacon("Beacon 1000"));
        beacons.add(new Beacon("Beacon 1001"));
        BeaconListAdapter beaconListAdapter = new BeaconListAdapter(beacons);
        binding.recylcerView.setAdapter(beaconListAdapter);
    }
}
