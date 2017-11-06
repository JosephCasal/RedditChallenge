package com.example.joseph.redditchallenge.view;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.joseph.redditchallenge.R;
import com.example.joseph.redditchallenge.RedditApplication;
import com.example.joseph.redditchallenge.model.Child;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RedditList extends AppCompatActivity implements RedditListContract.View {

    private static final String TAG = "MainActivityTag";

    private List<Child> childList = new ArrayList<>();

    @Inject
    RedditListPresenter presenter;
    private RecyclerView rvRedditList;
    private RecyclerView.LayoutManager layoutManager;
    private RedditListAdapter adapter;
//    private ProgressDialog progress;
//    private RecipeListScrollListener scrollListener;
    private String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupDaggerComponent();
        presenter.attachView(this);
        setupRecipeRecyclerView();
//        addonScrollListener();

        category = "funny";
        presenter.getList(category);


//        Toolbar toolbar = findViewById(R.id.main_toolbar);
//        setSupportActionBar(toolbar);
//
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =  findViewById(R.id.mySearchView);
//
//        // Assumes current activity is the searchable activity
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        searchView.setIconifiedByDefault(false); // Do not iconify the widget; expand it by default

    }

    private void setupDaggerComponent() {
        RedditApplication.get(this).getRedditListComponent().inject(this);
    }

    private void setupRecipeRecyclerView() {
        rvRedditList = findViewById(R.id.rvRedditList);
//        layoutManager = new GridLayoutManager(this, 3);
        layoutManager = new LinearLayoutManager(this);
        rvRedditList.setLayoutManager(layoutManager);
        adapter = new RedditListAdapter(this, childList);
        rvRedditList.setAdapter(adapter);
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void updateList(List<Child> childList) {
//        progress.dismiss();
        Log.d(TAG, "updateList: ");
        this.childList.addAll(childList);
        adapter.notifyDataSetChanged();
    }
}
