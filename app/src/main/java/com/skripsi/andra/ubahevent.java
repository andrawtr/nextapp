package com.skripsi.andra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ubahevent extends AppCompatActivity {
    TextView tvnamau,tvlokasiu,tvtamuu,tvtglu,tvjamu,tvtlpu,tvstatusu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubahevent);
        String nama = getIntent().getStringExtra("nama");
        String lokasi = getIntent().getStringExtra("lokasi");
        String tanggal = getIntent().getStringExtra("tanggal");
        String nope = getIntent().getStringExtra("nope");
        String tamu = getIntent().getStringExtra("tamu");
        String jam = getIntent().getStringExtra("jam");
        String status = getIntent().getStringExtra("status");
        String noevent = getIntent().getStringExtra("noevent");
        String uuid = getIntent().getStringExtra("uuid");
        tvnamau = findViewById(R.id.tvnamau);
        tvlokasiu = findViewById(R.id.tvlokasiu);
        tvtamuu = findViewById(R.id.tvtamuu);
        tvtglu = findViewById(R.id.tvtanggalu);
        tvjamu = findViewById(R.id.tvjamu);
        tvtlpu = findViewById(R.id.tvtlpu);
        tvstatusu = findViewById(R.id.tvstatusu);
        tvnamau.setText(nama);
        tvlokasiu.setText(lokasi);
        tvtamuu.setText(tamu);
        tvtglu.setText(tanggal);
        tvjamu.setText(jam);
        tvtlpu.setText(nope);
        tvstatusu.setText(status);
    }
}