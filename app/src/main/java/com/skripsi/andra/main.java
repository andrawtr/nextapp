package com.skripsi.andra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class main extends AppCompatActivity {
    TextView tv;
    ProgressDialog pd;
    String usernya;
    private FirebaseAuth mAuth;
    private DatabaseReference mdatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        pd = new ProgressDialog(main.this);
        pd.setMessage("Memeriksa Username ...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String uuid = user.getUid();
        mdatabase = FirebaseDatabase.getInstance().getReference().child("user").child(uuid).child("username");
        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pd.dismiss();
                usernya = dataSnapshot.getValue().toString();
                tv.setText("Selamat Datang "+usernya+" Di Portal Next Com");
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }
    public void buatevent(View v){
        startActivity(new Intent(main.this, buatevent.class));
    }
    public void abot(View v){
        startActivity(new Intent(main.this, about.class));
    }
    public void kesudah(View v){
        startActivity(new Intent(main.this, sudah.class));
    }
}