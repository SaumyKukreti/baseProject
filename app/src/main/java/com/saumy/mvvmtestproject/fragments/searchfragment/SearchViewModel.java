package com.saumy.mvvmtestproject.fragments.searchfragment;

import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.widget.Toast;

import com.saumy.mvvmtestproject.MyApp;
import com.saumy.mvvmtestproject.models.Bag;
import com.saumy.mvvmtestproject.retrofit.RemoteServices;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saumy on 2/25/2019.
 */

public class SearchViewModel extends ViewModel {
    public void getBags(RemoteServices remoteServices, String searchText) {
        remoteServices.genericCall().enqueue(new Callback<List<Bag>>() {
            @Override
            public void onResponse(Call<List<Bag>> call, Response<List<Bag>> response) {
                if (null != response && null != response.body())
                    Log.e("TAGG", String.valueOf(response.body().size()));
                else
                    Toast.makeText(MyApp.getInstance(), "Null response", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Bag>> call, Throwable t) {

            }
        });
    }
}
