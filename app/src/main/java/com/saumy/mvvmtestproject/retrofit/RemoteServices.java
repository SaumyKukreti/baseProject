package com.saumy.mvvmtestproject.retrofit;

import com.saumy.mvvmtestproject.models.Bag;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by saumy on 12/15/2018.
 */

public interface RemoteServices {

    @GET("/bags")
    Call<List<Bag>> genericCall ();
}
