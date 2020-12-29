package com.example.blogkita;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterListKategoriPilihan extends RecyclerView.Adapter<AdapterListKategoriPilihan.ListViewHolder> {

    Context
            context;

    List<ModelKategoriPilihan>
            kategoriPilihan;

    String
            namaKategoriPilihan;

    public AdapterListKategoriPilihan(List<ModelKategoriPilihan> kategoriPilihan, Context context, String namaKategoriPilihan) {
        this.context = context;
        this.kategoriPilihan = kategoriPilihan;
        this.namaKategoriPilihan = namaKategoriPilihan;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView
                judulPostingan,
                tglUpdate;
        ImageView
                imgPostingan;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            judulPostingan = itemView.findViewById(R.id.judulPost);
            tglUpdate = itemView.findViewById(R.id.tglPost);
            imgPostingan = itemView.findViewById(R.id.imagePost);
        }
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_kategori_pilihan, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final ModelKategoriPilihan currentItem = kategoriPilihan.get(position);

        if (currentItem.getKategoriNama().equals(namaKategoriPilihan)){
            holder.judulPostingan.setText(currentItem.getPostinganNama());
            holder.tglUpdate.setText(currentItem.getPostinganTanggal());
            Picasso.with(context).load("http://blog-kita.000webhostapp.com/Uploads/" + currentItem.getPostinganGambar()).into(holder.imgPostingan);
        }
    }

    @Override
    public int getItemCount() {
        return kategoriPilihan.size();
    }

}
