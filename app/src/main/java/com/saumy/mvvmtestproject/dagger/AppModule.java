package com.saumy.mvvmtestproject.dagger;

import android.content.Context;

import com.saumy.mvvmtestproject.MyApp;
import com.saumy.mvvmtestproject.constants.ApiConstants;
import com.saumy.mvvmtestproject.retrofit.RemoteServices;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by saumy on 10/17/2018.
 */

@Module
public class AppModule {

    @Provides
    RemoteServices getRemoteServices(){
        //Creating an HttpClient.Builder to attach interceptors
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        //Creating a logging interceptor
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        //Adding the logging interceptor to the http client
        client.addInterceptor(loggingInterceptor);

        //Creating a converter factory that will be used to serialise and de-serialise Json
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(gsonConverterFactory)
                .client(client.build()).build();

        return retrofit.create(RemoteServices.class);
    }
}
