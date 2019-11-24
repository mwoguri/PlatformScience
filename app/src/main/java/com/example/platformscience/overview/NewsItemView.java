package com.example.platformscience.overview;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.platformscience.R;
import com.example.platformscience.data.NewsItem;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;

@Layout(R.layout.news_list_item)
public class NewsItemView {

    @View(R.id.title)
    TextView title;

    @View(R.id.blurb)
    TextView blurb;

    @View(R.id.thumbnail)
    ImageView imageView;

    private NewsItem newsItem;
    private Context context;

    public NewsItemView(Context context, NewsItem newsItem) {
        this.context = context;
        this.newsItem = newsItem;
    }

    @Resolve
    void onResolved() {
        title.setText(newsItem.getTitle());
        blurb.setText(newsItem.getDescription());
        Glide.with(context).load(newsItem.getUrlToImage()).into(imageView);
    }
}