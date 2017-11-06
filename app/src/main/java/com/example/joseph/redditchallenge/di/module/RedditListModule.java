package com.example.joseph.redditchallenge.di.module;


import com.example.joseph.redditchallenge.data.remote.RemoteDataSource;
import com.example.joseph.redditchallenge.view.RedditListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by joseph on 11/6/17.
 */

@Module
public class RedditListModule {

    //    Only have the presenter here since this is the only dependency we are passing in the
//    RecipeDetail activity
//    @ActivityScope
    @Provides
    RedditListPresenter provideRedditListPresenter(RemoteDataSource remoteDataSource){
        return new RedditListPresenter(remoteDataSource);
    }
}
