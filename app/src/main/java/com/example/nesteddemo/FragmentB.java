package com.example.nesteddemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

public class FragmentB extends Fragment {
    private List<String> list;
    private NormalAdapter normalAdapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_layout,null);
        recyclerView = view.findViewById(R.id.rv_list);
        initList();
        initView();
        return view;
    }

    private void initList() {
        list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i + "B");
        }
    }

    private void initView() {
        linearLayoutManager = new LinearLayoutManager(getActivity());
        normalAdapter = new NormalAdapter(list);

        recyclerView.setLayoutManager(linearLayoutManager);
//        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(normalAdapter);
    }
}
