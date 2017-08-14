package com.m_eldeeb.smartware.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.m_eldeeb.smartware.interfaces.Communication;
import com.m_eldeeb.smartware.R;

import java.util.List;

/**
 * Created by melde on 8/7/2017.
 */

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
    private Context context;
Communication con;
List<Integer>list;

    public CourseAdapter(Context c, List<Integer> courses) {
list=courses;
        this.context = c;
    }

    @Override
    public CourseAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        CourseAdapter.ViewHolder holder = new CourseAdapter.ViewHolder(row);
        return holder;

    }

    @Override
    public void onBindViewHolder(CourseAdapter.ViewHolder holder, int position) {

        holder.logo.setImageResource(list.get(position));
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
            Log.v("fff","fff")
;        con.onClick(adapterPosition);

        }
    }
}


