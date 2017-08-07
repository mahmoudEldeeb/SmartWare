package com.m_eldeeb.smartware.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.m_eldeeb.smartware.R;

/**
 * Created by melde on 8/7/2017.
 */

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.ViewHolder> {
    private Context context;



    public PortfolioAdapter(Context c) {

        this.context = c;
    }

    @Override
    public PortfolioAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.portfolio_item, parent, false);
        PortfolioAdapter.ViewHolder holder = new PortfolioAdapter.ViewHolder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(PortfolioAdapter.ViewHolder holder, int position) {
      /*  holder.name.setText(marketList.get(position).getMarketName());

        holder.logo.setImageResource(marketList.get(position).getImage());*/
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;

        TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();

        }
    }
}

