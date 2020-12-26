package com.example.blogkita;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class TagFragment extends Fragment {

    List<ModelKategori> kategoriUtama;

    RecyclerView recyclerViewKategori;

    RecyclerView.Adapter adapterKategori;

    RecyclerView.LayoutManager layoutManagerKategori;

    RequestQueue requestQueueKategori;

    JsonArrayRequest jsonArrayRequestKategori;

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

        adapterKategori = new ListKategori(kategoriUtama, getActivity());
        recyclerViewKategori.setAdapter(adapterKategori);

        ((MainActivity) requireContext()).getMysqlKategori(kategoriUtama, adapterKategori);
    }

}

