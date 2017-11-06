package com.example.joseph.redditchallenge.di.component;

import com.example.joseph.redditchallenge.di.module.AppModule;
import com.example.joseph.redditchallenge.di.module.RedditListModule;
import com.example.joseph.redditchallenge.di.scope.AppScope;

import dagger.Component;

/**
 * Created by joseph on 11/6/17.
 */

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {


    RedditListComponent plus(RedditListModule redditListModule);

//    RecipeDetailComponent plus(RecipeDetailModule recipeDetailModule);


}
