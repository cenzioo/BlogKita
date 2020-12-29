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
import com.example.blogkita.AdapterListKategoriPilihan;
import com.example.blogkita.AdapterListPostinganPilihan;
import com.example.blogkita.ModelKategoriPilihan;
import com.example.blogkita.ModelPostPilihan;
import com.example.blogkita.R;
import com.example.blogkita.activity.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class PostPilihanFragment extends Fragment {
    List<ModelPostPilihan>
        listPostPilihan;

    RecyclerView
            recyclerViewPostPilihan;

    RecyclerView.Adapter
            adapterPostPilihan;

    RecyclerView.LayoutManager
            layoutManagerPostPilihan;

    RequestQueue
            requestQueuePostPilihan;

    JsonArrayRequest
            jsonArrayRequestPostPilihan;

    public static String
            postPilihan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post_pilihan, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerViewPostPilihan= requireView().findViewById(R.id.daftarPostPilihan);

        listPostPilihan = new ArrayList<>();

        layoutManagerPostPilihan = new LinearLayoutManager(getActivity());

        recyclerViewPostPilihan.setHasFixedSize(true);
        recyclerViewPostPilihan.setLayoutManager(layoutManagerPostPilihan);

        adapterPostPilihan = new AdapterListPostinganPilihan(listPostPilihan, getActivity(), postPilihan);
        recyclerViewPostPilihan.setAdapter(adapterPostPilihan);

        ((MainActivity) requireContext()).getMysqlListPostPilihan(listPostPilihan, adapterPostPilihan);
    }
}
