package com.example.blogkita;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.blogkita.fragment.TagPilihanFragment;

import java.util.List;

public class ListKategori extends RecyclerView.Adapter<ListKategori.ListViewHolder> {

    Context
            context;

    List<ModelKategori>
            kategori;

    public ListKategori(List<ModelKategori> kategori, Context context) {
        this.context = context;
        this.kategori = kategori;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView
                textKategori;


        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            textKategori = itemView.findViewById(R.id.teksKategori);
        }
    }

    @NonNull
    @Override
    public ListKategori.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_kategori, parent, false);

        return new ListViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ListKategori.ListViewHolder holder, int position) {
        final ModelKategori currentItem = kategori.get(position);

        holder.textKategori.setText(currentItem.getKategoriNama());

        holder.textKategori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TagPilihanFragment.kategoriPilihan = currentItem.getKategoriNama();

                AppCompatActivity activity = (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TagPilihanFragment()).addToBackStack("Berita").commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return kategori.size();
    }
}
