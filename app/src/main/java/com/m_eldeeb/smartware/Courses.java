package com.m_eldeeb.smartware;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.m_eldeeb.smartware.adapter.CourseAdapter;
import com.m_eldeeb.smartware.adapter.PortfolioAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Courses extends Fragment {


    public Courses() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    CourseAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_courses, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.res);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CourseAdapter(getActivity());
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    return view;}

}
