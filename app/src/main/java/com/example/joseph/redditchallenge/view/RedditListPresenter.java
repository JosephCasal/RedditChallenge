package com.example.joseph.redditchallenge.view;

import android.util.Log;

import com.example.joseph.redditchallenge.data.remote.RemoteDataSource;
import com.example.joseph.redditchallenge.model.Child;
import com.example.joseph.redditchallenge.model.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by joseph on 11/6/17.
 */

public class RedditListPresenter implements RedditListContract.Presenter {

//    public static final int INIT_ITEMS = 0;

    RemoteDataSource remoteDataSource;

    @Inject
    public RedditListPresenter(RemoteDataSource remoteDataSource){
        this.remoteDataSource = remoteDataSource;
    }

    RedditListContract.View view;
    List<Child> redditList = new ArrayList<>();
    public static final String TAG = "RedditListPresenter";

    @Override
    public void attachView(RedditListContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }


    @Override
    public void getList(String category) {

        Observer<Child> observer = new Observer<Child>() {
            @Override
            public void onSubscribe(Disposable d) {

                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Child child) {
                Log.d(TAG, "onNext: " + child.getData().getAuthor());

                redditList.add(child);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.getMessage());
                view.showError(e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
//                view.updateRecipes(redditList);
                view.updateList(redditList);
            }
        };

//        String from = String.valueOf(fromItemNumber);
//        String to = String.valueOf(fromItemNumber + 20);
        remoteDataSource.getResponse(category)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<Response, Observable<Child>>() {
                    @Override
                    public Observable<Child> apply(final Response response) throws Exception {

                        return Observable.create(new ObservableOnSubscribe<Child>() {
                            @Override
                            public void subscribe(ObservableEmitter<Child> e) throws Exception {

                                Log.d(TAG, "subscribe: ");

                                for (Child child : response.getData().getChildren()) {
                                    e.onNext(child);
                                }
                                e.onComplete();


                            }
                        });
                    }
                })
                .subscribe(observer);

    }
}
