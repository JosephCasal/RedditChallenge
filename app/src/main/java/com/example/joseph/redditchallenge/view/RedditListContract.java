package com.example.joseph.redditchallenge.view;

import com.example.joseph.redditchallenge.model.Child;
import com.example.joseph.redditchallenge.utils.BasePresenter;
import com.example.joseph.redditchallenge.utils.BaseView;

import java.util.List;

/**
 * Created by joseph on 11/6/17.
 */

public interface RedditListContract {

    interface View extends BaseView {

        void updateList(List<Child> childList);
//        void showProgress(int MODE);
    }

    interface Presenter extends BasePresenter<View> {
        void getList(String category);


    }

}
