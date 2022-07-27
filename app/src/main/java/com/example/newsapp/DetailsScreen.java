package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsapp.Models.NewsHeadlines;

public class DetailsScreen extends AppCompatActivity {
    NewsHeadlines headlines;
    TextView t_title, t_author, t_time, t_detail, t_content;
    ImageView img_news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_screen);

        t_title = findViewById(R.id.text_detail_title);
        t_author = findViewById(R.id.text_detail_auth);
        t_time = findViewById(R.id.text_detail_time);
        t_detail = findViewById(R.id.text_detail_detail);
        t_content = findViewById(R.id.text_detail_content);
        img_news = findViewById(R.id.img_news);

        headlines = (NewsHeadlines) getIntent().getSerializableExtra("data");

        t_title.setText(headlines.getTitle());
        t_author.setText(headlines.getAuthor());
        t_time.setText(headlines.getPublishedAt());
        t_detail.setText(headlines.getDescription());
        t_content.setText(headlines.getContent());
        Glide.with(DetailsScreen.this).load(headlines.getUrlToImage())
                .into(img_news);   }
}