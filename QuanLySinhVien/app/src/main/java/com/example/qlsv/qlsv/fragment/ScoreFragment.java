package com.example.qlsv.qlsv.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qlsv.qlsv.DetailActivity;
import com.example.qlsv.qlsv.R;
import com.example.qlsv.qlsv.adapter.RecycleAdapter;
import com.example.qlsv.qlsv.custom.RecyclerItemClickListener;
import com.example.qlsv.qlsv.model.Score;

import java.util.ArrayList;

public class ScoreFragment extends Fragment{

    public ScoreFragment(){

    }
    RecyclerView recyclerView;
    RecycleAdapter adapter;
    private ArrayList<Score> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewList);
        adapter = new RecycleAdapter(createData());

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        Intent intent = new Intent(view.getContext(),DetailActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                        Intent intent = new Intent(view.getContext(),DetailActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                })
        );
        return view;
    }

    public ArrayList<Score> createData(){
        data.add(new Score("Hoa1","1.5","HT"));
        data.add(new Score("Hoa2","2.5","HT"));
        data.add(new Score("Hoa3","3.5","HT"));
        data.add(new Score("Hoa4","4.5","HT"));
        data.add(new Score("Hoa5","5.5","HT"));
        data.add(new Score("Hoa6","6.5","HT"));
        data.add(new Score("Hoa7","7.5","HT"));
        data.add(new Score("Hoa8","8.5","HT"));
        data.add(new Score("Hoa9","9.5","HT"));
        data.add(new Score("Hoa10","10.5","HT"));
        data.add(new Score("Van1","1.5","HT"));
        data.add(new Score("Van2","2.5","HT"));
        data.add(new Score("Van3","3.5","HT"));
        data.add(new Score("Van4","4.5","HT"));
        data.add(new Score("Van5","5.5","HT"));
        data.add(new Score("Van6","6.5","HT"));
        data.add(new Score("Van7","7.5","HT"));
        data.add(new Score("Van8","8.5","HT"));
        data.add(new Score("Van9","9.5","HT"));
        data.add(new Score("Van10","10.5","HT"));
        return data;
    }
}
