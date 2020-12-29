package com.example.blogkita.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.blogkita.ModelKategori;
import com.example.blogkita.ModelKategoriPilihan;
import com.example.blogkita.ModelPostingan;
import com.example.blogkita.R;
import com.example.blogkita.fragment.HomeFragment;
import com.example.blogkita.fragment.SearchFragment;
import com.example.blogkita.fragment.TagFragment;
import com.example.blogkita.fragment.TagPilihanFragment;
import com.example.blogkita.fragment.UserFragment;
import com.example.blogkita.fragment.WriteFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RequestQueue
        requestQueue;

    JsonArrayRequest
        jsonArrayRequest;

    public static final String
        IP_ADDRESS = "http://blog-kita.000webhostapp.com/AndroidDatabase",
        DATA_KATEGORI = IP_ADDRESS + "/GetKategori.php",
        DATA_POSTINGAN = IP_ADDRESS + "/GetListPost.php",
        DATA_KATEGORI_PILIHAN = IP_ADDRESS + "/GetKategoriPilihan.php",
        DATA_LOGIN = IP_ADDRESS + "/Login.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.nav_write:
                            selectedFragment = new WriteFragment();
                            break;
                        case R.id.nav_tag:
                            selectedFragment = new TagFragment();
                            break;
                        case R.id.nav_user:
                            selectedFragment = new UserFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
    public void getMysqlKategori(final List<ModelKategori> Kategori, final RecyclerView.Adapter adapterkategori){
        jsonArrayRequest = new JsonArrayRequest(DATA_KATEGORI,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        getKategori(response, Kategori);

                        adapterkategori.notifyDataSetChanged();

//                        Toast.makeText(MainActivity.this, "" + Kategori.size(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });

        requestQueue = Volley.newRequestQueue(MainActivity.this);

        requestQueue.add(jsonArrayRequest);
    }

    public void getKategori (JSONArray jsonArray, List<ModelKategori> Kategori){
        for (int i = 0; i < jsonArray.length(); i++){
            try {
                ModelKategori currentKategori = new ModelKategori();

                JSONObject jsonObject = jsonArray.getJSONObject(i);

                currentKategori.setKategoriID(jsonObject.getInt("idkategori"));
                currentKategori.setKategoriNama(jsonObject.getString("nama"));

                Kategori.add(currentKategori);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getMysqlListPostingan(final List<ModelPostingan> Postingan, final RecyclerView.Adapter adapterpostingan){
        jsonArrayRequest = new JsonArrayRequest(DATA_POSTINGAN,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        getListPostingan(response, Postingan);
                        adapterpostingan.notifyDataSetChanged();
//                        Toast.makeText(MainActivity.this, "" + Postingan.size(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonArrayRequest);
    }

    public void getListPostingan (JSONArray jsonArray, List<ModelPostingan> Postingan){
        for (int i = 0; i < jsonArray.length(); i++){
            try {
                ModelPostingan currentPostingan = new ModelPostingan();
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                currentPostingan.setPostinganNama(jsonObject.getString("judul"));
                currentPostingan.setPostinganTanggal(jsonObject.getString("tgl_insert"));
                currentPostingan.setPostinganGambar(jsonObject.getString("file_gambar"));

                Postingan.add(currentPostingan);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void getMysqlListKategoriPilihan(final List<ModelKategoriPilihan> KategoriPilihan, final RecyclerView.Adapter adapterkategoripilihan){
        jsonArrayRequest = new JsonArrayRequest(DATA_KATEGORI_PILIHAN,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        getListKategoriPilihan(response, KategoriPilihan);
                        adapterkategoripilihan.notifyDataSetChanged();
   //                     Toast.makeText(MainActivity.this, "" + KategoriPilihan.size(), Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                });
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(jsonArrayRequest);
    }

    public void getListKategoriPilihan (JSONArray jsonArray, List<ModelKategoriPilihan> KategoriPilihan){
        for (int i = 0 ; i < jsonArray.length(); i++){
            try {
                ModelKategoriPilihan currentKategoriPilihan = new ModelKategoriPilihan();
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                currentKategoriPilihan.setPostinganNama(jsonObject.getString("judul"));
                currentKategoriPilihan.setPostinganTanggal(jsonObject.getString("tgl_insert"));
                currentKategoriPilihan.setPostinganGambar(jsonObject.getString("file_gambar"));
                currentKategoriPilihan.setKategoriNama(jsonObject.getString("nama"));

                if (jsonObject.getString("nama").equals(TagPilihanFragment.kategoriPilihan)){
                    KategoriPilihan.add(currentKategoriPilihan);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}