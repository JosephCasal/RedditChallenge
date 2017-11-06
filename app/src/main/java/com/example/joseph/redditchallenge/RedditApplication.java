package com.example.joseph.redditchallenge;

import android.app.Application;
import android.content.Context;

import com.example.joseph.redditchallenge.di.component.AppComponent;
import com.example.joseph.redditchallenge.di.component.DaggerAppComponent;
import com.example.joseph.redditchallenge.di.component.RedditListComponent;
import com.example.joseph.redditchallenge.di.module.AppModule;
import com.example.joseph.redditchallenge.di.module.RedditListModule;

/**
 * Created by joseph on 11/6/17.
 */

public class RedditApplication extends Application {

    private AppComponent appComponent;
    private RedditListComponent redditListComponent;
    public static final String BASEURL = "https://www.reddit.com/";
//    private RecipeDetailComponent recipeDetailComponent;

    @Override
    public void onCreate() {
        super.onCreate();


        AppModule appModule = new AppModule(BASEURL, getApplicationContext());
        appComponent = DaggerAppComponent.builder()
                .appModule(appModule)
                .build();

    }

    public static RedditApplication get(Context context) {
        return (RedditApplication) context.getApplicationContext();
    }


    public RedditListComponent getRedditListComponent() {

        redditListComponent = appComponent.plus(new RedditListModule());
        return redditListComponent;
    }
//    public RecipeDetailComponent getRecipeDetailComponent() {
//
//        recipeDetailComponent = appComponent.plus(new RecipeDetailModule());
//        return recipeDetailComponent;
//    }

    public void clearRedditListComponent() {
        redditListComponent = null;

    }
//    public void clearRecipeDetailComponent() {
//        recipeListComponent = null;
//
//    }

}
