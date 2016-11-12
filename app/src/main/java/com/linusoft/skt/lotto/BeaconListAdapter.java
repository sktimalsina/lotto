package com.linusoft.skt.lotto;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linusoft.skt.lotto.databinding.ListitemBeaconListBinding;

import java.util.List;

/**
 * Created by sunil on 2016-10-01.
 */
public class BeaconListAdapter extends RecyclerView.Adapter<BeaconListAdapter.ViewHolder> {

    @Nullable
    private List<Beacon> beacons;

    BeaconListAdapter(List<Beacon> beacons) {
        this.beacons = beacons;
    }

    public void setBeacons(@Nullable List<Beacon> beacons) {
        this.beacons = beacons;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_beacon_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (beacons == null) {
            return;
        }
        Beacon beacon = beacons.get(position);
        holder.getBinding().setBeaconName(beacon == null ? "-" : beacon.getBeaconName());
        holder.getBinding().setBeaconId(beacon == null ? "-" : beacon.getBeaconId());
    }

    @Override
    public int getItemCount() {
        return beacons == null ? 0 : beacons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListitemBeaconListBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ListitemBeaconListBinding getBinding() {
            return binding;
        }
    }
}
