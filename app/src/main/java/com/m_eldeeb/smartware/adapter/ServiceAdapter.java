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

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {
    private Context context;



    public ServiceAdapter(Context c) {

        this.context = c;
    }

    @Override
    public ServiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.service_item, parent, false);
        ServiceAdapter.ViewHolder holder = new ServiceAdapter.ViewHolder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(ServiceAdapter.ViewHolder holder, int position) {
      switch (position) {
          case 0:holder.title.setText(R.string.android);
              holder.desc.setText(R.string.android_desc);
              break;
          case 1:holder.title.setText(R.string.web);
              holder.desc.setText(R.string.web_desc);
              break;
          case 2:holder.title.setText(R.string.design);
              holder.desc.setText(R.string.design_desc);
              break;
      }

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;

        TextView desc;

        public ViewHolder(View itemView) {
            super(itemView);
title= (TextView) itemView.findViewById(R.id.title);

            desc= (TextView) itemView.findViewById(R.id.desc);
            itemView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();

        }
    }
}
