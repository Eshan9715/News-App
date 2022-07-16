package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newsapp.Models.NewsHeadlines;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {
    private Context context;
    private List<NewsHeadlines> headlinesList;
    private SelectListener selectListener;

    public CustomAdapter(Context context, List<NewsHeadlines> headlinesList, SelectListener selectListener) {
        this.context = context;
        this.headlinesList = headlinesList;
        this.selectListener = selectListener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headlines_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.text_title.setText(headlinesList.get(position).getTitle());
        holder.text_source.setText(headlinesList.get(position).getSource().getName());
        if(headlinesList.get(position).getUrlToImage()!=null){
            Glide.with(context).load(headlinesList.get(position)).into(holder.img_headline);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectListener.OnNewsClicked(headlinesList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return headlinesList.size();
    }
}
