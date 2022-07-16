package com.skripsi.andra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class main<ImageAdapter> extends AppCompatActivity {
    TextView tv;
    ProgressDialog pd;
    String usernya, uuid;
    private FirebaseAuth mAuth;
    private DatabaseReference mdatabase;
    private Signin signin = new Signin();
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    private Context mContext;
    private Activity mActivity;
    private ArrayList<Model> imagesList;
    private holdereventuser imageAdapter = null;

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
        uuid = user.getUid();
        mActivity = main.this;
        mContext = getApplicationContext();
        FirebaseApp.initializeApp(this);
        recyclerView = findViewById(R.id.rview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2, GridLayoutManager.VERTICAL, false));
        recyclerView.setNestedScrollingEnabled(false);
        imagesList = new ArrayList<>();

        databaseReference = FirebaseDatabase.getInstance().getReference().child("user").child(uuid).child("userevent");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                imagesList.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Model imagemodel = dataSnapshot.getValue(Model.class);
                    imagesList.add(imagemodel);
                }
                imageAdapter = new holdereventuser(mContext, mActivity, (ArrayList<Model>) imagesList);
                recyclerView.setAdapter(imageAdapter);
                imageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(main.this, "Error:" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        mdatabase = FirebaseDatabase.getInstance().getReference().child("user").child(uuid).child("username");
        mdatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pd.dismiss();
                usernya = dataSnapshot.getValue().toString();
                tv.setText("Selamat Datang " + usernya + " Di Portal Next Com");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

    }

    public void buatevent(View v) {
        this.finish();
        startActivity(new Intent(main.this, buatevent.class));
    }
}
