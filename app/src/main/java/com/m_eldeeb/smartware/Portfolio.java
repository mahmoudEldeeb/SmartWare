package com.m_eldeeb.smartware;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.m_eldeeb.smartware.adapter.PortfolioAdapter;
import com.m_eldeeb.smartware.adapter.ServiceAdapter;
import com.m_eldeeb.smartware.models.PortfolioModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Portfolio extends Fragment {


    public Portfolio() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    PortfolioAdapter adapter;
    ProgressBar progressBar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_portfolio, container, false);
        progressBar= (ProgressBar) view.findViewById(R.id.progressBar4);

        progressBar.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView) view.findViewById(R.id.res);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        getPortfolio();
        return view;
    }

    public void getPortfolio(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference Portfolios = database.getReference("Portfolio");
        Portfolios.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        HashMap<String, PortfolioModel> results = dataSnapshot.getValue(new GenericTypeIndicator<HashMap<String,PortfolioModel >>() {
        });
        Log.v("dd","gg");
        List<PortfolioModel> portfolioList = new ArrayList<>(results.values());
        adapter = new PortfolioAdapter(getActivity(),portfolioList);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

        Log.v("dd","gg");
        progressBar.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onCancelled(DatabaseError databaseError) {

        progressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(getActivity(), "there is some problem try later ", Toast.LENGTH_SHORT).show();

    }
});
/*        Portfolios.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                HashMap<String, PortfolioModel> results = dataSnapshot.getValue(new GenericTypeIndicator<HashMap<String,PortfolioModel >>() {
                });
                Log.v("dd","gg");
                List<PortfolioModel> portfolioList = new ArrayList<>(results.values());
                adapter = new PortfolioAdapter(getActivity(),portfolioList);
                adapter.notifyDataSetChanged();
                recyclerView.setAdapter(adapter);

                Log.v("dd","gg");
                }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }



        });
*/

    }

}
