package com.example.blogkita.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.blogkita.ListKategori;
import com.example.blogkita.ListPostingan;
import com.example.blogkita.ModelKategori;
import com.example.blogkita.ModelPostingan;
import com.example.blogkita.R;
import com.example.blogkita.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    List<ModelPostingan>
            listPostingan;

    RecyclerView
            recyclerViewListPostingan;

    RecyclerView.Adapter
            adapterPostingan;

    RecyclerView.LayoutManager
            layoutManagerListPostingan;

    RequestQueue
            requestQueueListPostingan;

    JsonArrayRequest
            jsonArrayRequestPostingan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewListPostingan = requireView().findViewById(R.id.daftarKategori);

        listPostingan = new ArrayList<>();

        layoutManagerListPostingan = new LinearLayoutManager(getActivity());

        recyclerViewListPostingan.setHasFixedSize(true);
        recyclerViewListPostingan.setLayoutManager(layoutManagerListPostingan);

        adapterPostingan = new ListPostingan(listPostingan, getActivity());
        recyclerViewListPostingan.setAdapter(adapterPostingan);

        ((MainActivity) requireContext()).getMysqlListPostingan(listPostingan, adapterPostingan);
    }
}

