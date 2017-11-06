package com.example.joseph.redditchallenge.di.component;

import com.example.joseph.redditchallenge.di.module.RedditListModule;
import com.example.joseph.redditchallenge.view.RedditList;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by joseph on 11/6/17.
 */

@Subcomponent(modules = RedditListModule.class)
public interface RedditListComponent {

    void inject(RedditList redditList);

}
