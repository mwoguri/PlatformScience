package com.example.platformscience.overview;

import android.util.Log;

import com.example.platformscience.R;
import com.example.platformscience.data.NewsController;
import com.example.platformscience.data.NewsItem;
import com.example.platformscience.data.NewsResponse;
import com.mindorks.placeholderview.InfinitePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.infinite.LoadMore;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Layout(R.layout.load_more_view)
public class NewsListView implements Callback<NewsResponse> {
    static String TAG = "NewsListView";

    private InfinitePlaceHolderView mLoadMoreView;
    private List<NewsItem> mFeedList;
    private int currentPage = 1;

    public NewsListView(InfinitePlaceHolderView loadMoreView, List<NewsItem> feedList) {
        this.mLoadMoreView = loadMoreView;
        this.mFeedList = feedList;
    }

    @LoadMore
    void onLoadMore() {
        Log.d(TAG, "onLoadMore");
        NewsController controller = new NewsController();
        controller.requestPage(currentPage++, this);
    }

    @Override
    public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
        if (response.isSuccessful()) {
            NewsResponse news = response.body();
            Log.d(TAG, news.toString());

            for (NewsItem item : news.getArticles()) {
                mFeedList.add(item);
                mLoadMoreView.addView(new NewsItemView(mLoadMoreView.getContext(), item));
            }

            mLoadMoreView.loadingDone();

        } else {
            Log.e(TAG, "Error: " + response.code());
        }
    }

    @Override
    public void onFailure(Call<NewsResponse> call, Throwable t) {
        Log.e(TAG, t.getLocalizedMessage());
    }

}