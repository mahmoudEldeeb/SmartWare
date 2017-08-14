package com.m_eldeeb.smartware.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.m_eldeeb.smartware.interfaces.Communication;
import com.m_eldeeb.smartware.R;
import com.m_eldeeb.smartware.models.PortfolioModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by melde on 8/7/2017.
 */

public class
PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.ViewHolder> {
    private Context context;
Communication con;
List<PortfolioModel>list=new ArrayList<>();

    public PortfolioAdapter(Context c, List<PortfolioModel> portfolioList) {
        list=portfolioList;
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


try {


    Picasso.with(context)
            .load(String.valueOf(list.get(position).getLogo())).fit()
            .into(holder.logo);
}
catch (Exception e){}
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView logo;
        public ViewHolder(View itemView) {
            super(itemView);
            con= (Communication) context;
            logo= (ImageView) itemView.findViewById(R.id.logo);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            con.onClick(list.get(adapterPosition));

        }
    }
}

