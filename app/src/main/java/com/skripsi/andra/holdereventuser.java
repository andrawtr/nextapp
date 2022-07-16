package com.skripsi.andra;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

public class holdereventuser extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private Activity mActivity;
    private ArrayList<Model> mContentList;

    public holdereventuser(Context mContext, Activity mActivity, ArrayList<Model> mContentList) {
        this.mContext = mContext;
        this.mActivity = mActivity;
        this.mContentList = mContentList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_holdereventuser, parent, false);
        return new ViewHolder(view, viewType);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvnamae,tvlokasie,tvtamue,tvtanggale,tvjame,tvstatuse;
        private CardView cardView;
        public ViewHolder(View itemView, int viewType) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cv);
            tvnamae = (TextView) itemView.findViewById(R.id.tvnamae);
            tvlokasie = (TextView) itemView.findViewById(R.id.tvlokasie);
            tvtanggale = (TextView) itemView.findViewById(R.id.tvtanggale);
            tvtamue = (TextView) itemView.findViewById(R.id.tvtamue);
            tvjame = (TextView) itemView.findViewById(R.id.tvjame);
            tvstatuse = (TextView) itemView.findViewById(R.id.tvstatuse);
        }
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder mainHolder, int position) {
        ViewHolder holder = (ViewHolder) mainHolder;
        final Model model = mContentList.get(position);
        // setting data over views
        holder.tvnamae.setText(model.getJenis());
        holder.tvlokasie.setText(model.getLokasi());
        holder.tvtanggale.setText(model.getTanggal());
        holder.tvtamue.setText(model.getTamu());
        holder.tvjame.setText(model.getJam());
        holder.tvstatuse.setText(model.getStatus());
    }
    @Override
    public int getItemCount() {
        return mContentList.size();
    }
}

