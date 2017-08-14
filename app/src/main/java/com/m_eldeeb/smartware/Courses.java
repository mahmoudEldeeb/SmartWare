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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Courses extends Fragment {


    public Courses() {
        // Required empty public constructor
    }


    RecyclerView recyclerView;
    CourseAdapter adapter;
List<Integer>courses=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_courses, container, false);
courses.add(R.drawable.android);
        courses.add(R.drawable.php);
        courses.add(R.drawable.gd);
        courses.add(R.drawable.asp);
        courses.add(R.drawable.webdesign);
        recyclerView = (RecyclerView) view.findViewById(R.id.res);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CourseAdapter(getActivity(),courses);

        recyclerView.setAdapter(adapter);
    return view;}

}
