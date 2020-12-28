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
import com.example.blogkita.ListKategoriPilihan;
import com.example.blogkita.ListPostingan;
import com.example.blogkita.ModelKategoriPilihan;
import com.example.blogkita.ModelPostingan;
import com.example.blogkita.R;
import com.example.blogkita.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class TagPilihanFragment extends Fragment {

    List<ModelKategoriPilihan>
            listKategoriPilihan;

    RecyclerView
            recyclerViewKategoriPilihan;

    RecyclerView.Adapter
            adapterKategoriPilihan;

    RecyclerView.LayoutManager
            layoutManagerKategoriPilihan;

    RequestQueue
            requestQueueKategoriPilihan;

    JsonArrayRequest
            jsonArrayRequestKategoriPilihan;

    public static String
            kategoriPilihan;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tag_pilihan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewKategoriPilihan = requireView().findViewById(R.id.daftarKategoriPilihan);

        listKategoriPilihan = new ArrayList<>();

        layoutManagerKategoriPilihan = new LinearLayoutManager(getActivity());

        recyclerViewKategoriPilihan.setHasFixedSize(true);
        recyclerViewKategoriPilihan.setLayoutManager(layoutManagerKategoriPilihan);

        adapterKategoriPilihan = new ListKategoriPilihan(listKategoriPilihan, getActivity(), kategoriPilihan);
        recyclerViewKategoriPilihan.setAdapter(adapterKategoriPilihan);

        ((MainActivity) requireContext()).getMysqlListKategoriPilihan(listKategoriPilihan, adapterKategoriPilihan);
    }
}

