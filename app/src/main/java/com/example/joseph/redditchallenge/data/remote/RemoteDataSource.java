package com.example.joseph.redditchallenge.data.remote;

import android.content.Context;
import android.util.Log;

import com.example.joseph.redditchallenge.model.Child;
import com.example.joseph.redditchallenge.model.Response;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by joseph on 11/6/17.
 */

public class RemoteDataSource {

    public static final String TAG = "RemoteDataSourceTag";

    Context context;

    private String BASE_URL;

    @Inject
    public RemoteDataSource(String BASE_URL, Context context) {
        Log.d(TAG, "RemoteDataSource: " + BASE_URL);
//        this.BASE_URL = BASE_URL;
        this.BASE_URL = "https://www.reddit.com";
        this.context = context;
    }

    public Retrofit create(){


//        int cacheSize = 10 * 1024 * 1024;
//
//        Cache cache = new Cache(context.getCacheDir(), cacheSize);
//
//
//        //Create a logging interceptor
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
//
//        //create a client for the adding the interceptor
//        OkHttpClient client = new OkHttpClient.Builder()
//                .addInterceptor(logging)
//                .cache(cache)
//                .build();




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .client(client)//add the client to use logging interceptor
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;

    }

    public Observable<Response> getResponse(String category){
        Retrofit retrofit = create();
        RemoteService remoteService = retrofit.create(RemoteService.class);
//        return remoteService.getReddit(category);
        return remoteService.getReddit();
    }

}
