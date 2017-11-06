package com.example.joseph.redditchallenge.data.remote;

import com.example.joseph.redditchallenge.model.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by joseph on 11/6/17.
 */

public interface RemoteService {

//    @GET("r/{category}/.json")
//    Observable<Response> getReddit(@Path("category") String category);
    @GET("/r/funny/.json")
    Observable<Response> getReddit();

}
