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
import com.example.blogkita.AdapterListKategori;
import com.example.blogkita.activity.MainActivity;
import com.example.blogkita.ModelKategori;
import com.example.blogkita.R;

import java.util.ArrayList;
import java.util.List;


public class TagFragment extends Fragment {

    List<ModelKategori>
        kategoriUtama;

    RecyclerView
        recyclerViewKategori;

    RecyclerView.Adapter
        adapterKategori;

    RecyclerView.LayoutManager
        layoutManagerKategori;

    RequestQueue
        requestQueueKategori;

    JsonArrayRequest
        jsonArrayRequestKategori;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewKategori = requireView().findViewById(R.id.daftarKategori);

        kategoriUtama = new ArrayList<>();

        layoutManagerKategori = new LinearLayoutManager(getActivity());

        recyclerViewKategori.setHasFixedSize(true);
        recyclerViewKategori.setLayoutManager(layoutManagerKategori);

        adapterKategori = new AdapterListKategori(kategoriUtama, getActivity());
        recyclerViewKategori.setAdapter(adapterKategori);

        ((MainActivity) requireContext()).getMysqlKategori(kategoriUtama, adapterKategori);
    }

}

