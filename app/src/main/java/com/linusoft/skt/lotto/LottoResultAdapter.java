package com.linusoft.skt.lotto;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.linusoft.skt.lotto.databinding.ListitemTicketListBinding;
import com.linusoft.skt.lotto.utils.LottoResult;

import java.util.List;

/**
 * Created by sunil on 2016-10-01.
 */
public class LottoResultAdapter extends RecyclerView.Adapter<LottoResultAdapter.ViewHolder> {

    @Nullable
    private List<LottoResult> lottoResults;

    public void setLottoResults(@Nullable List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return  new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_ticket_list, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (lottoResults == null) {
            return;
        }
        LottoResult result = lottoResults.get(position);
        holder.getBinding().setWinningNumber(result.getWinningNumbers().toString());
        holder.getBinding().setBonusNumber(String.valueOf(result.getNum_bonus()));
    }

    @Override
    public int getItemCount() {
        return lottoResults == null ? 0 : lottoResults.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ListitemTicketListBinding binding;

        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public ListitemTicketListBinding getBinding() {
            return binding;
        }
    }
}
