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

public class AdapterListPostinganPilihan extends RecyclerView.Adapter<AdapterListPostinganPilihan.ListViewHolder> {

    Context
            context;

    List<ModelPostPilihan>
            postPilihan;

    String
            namaPostPilihan;

    public AdapterListPostinganPilihan(List<ModelPostPilihan> postPilihan, Context context, String namaPostPilihan) {
        this.context = context;
        this.postPilihan = postPilihan;
        this.namaPostPilihan = namaPostPilihan;
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {

        TextView
                judulPostingan,
                isiPostingan;
        ImageView
                imgPostingan;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            judulPostingan = itemView.findViewById(R.id.judulPost);
            isiPostingan = itemView.findViewById(R.id.isiPost);
            imgPostingan = itemView.findViewById(R.id.imagePost);
        }
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_post_pilihan, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final ModelPostPilihan currentItem = postPilihan.get(position);

        if (currentItem.getPostinganNama().equals(namaPostPilihan)){
            holder.judulPostingan.setText(currentItem.getPostinganNama());
            holder.isiPostingan.setText(currentItem.getPostinganIsi());
            Picasso.with(context).load("http://blog-kita.000webhostapp.com/Uploads/" + currentItem.getPostinganGambar()).into(holder.imgPostingan);
        }

    }

    @Override
    public int getItemCount() {
        return postPilihan.size();
    }

}
