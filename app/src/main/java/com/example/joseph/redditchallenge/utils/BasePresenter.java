package com.example.joseph.redditchallenge.utils;

/**
 * Created by joseph on 11/6/17.
 */

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);
    void detachView();

}
