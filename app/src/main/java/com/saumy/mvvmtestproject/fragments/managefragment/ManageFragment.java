package com.saumy.mvvmtestproject.fragments.managefragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.saumy.mvvmtestproject.MyApp;
import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.Utils;
import com.saumy.mvvmtestproject.databinding.FragmentManageBinding;
import com.saumy.mvvmtestproject.models.Bag;
import com.saumy.mvvmtestproject.models.DeleteResponse;
import com.saumy.mvvmtestproject.retrofit.RemoteServices;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ManageFragment extends Fragment implements ManageFragmentListener {

    private static final String TAG = ManageFragment.class.getSimpleName();
    @Inject
    RemoteServices mRemoteServices;

    private FragmentManageBinding manageBinding;

    public ManageFragment() {
        // Required empty public constructor
    }

    public static ManageFragment newInstance() {
        ManageFragment fragment = new ManageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        MyApp.getInstance().getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        manageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_manage, container, false);
        manageBinding.setListener(this);
        return manageBinding.getRoot();
    }

    @Override
    public void generateNewRecord() {
        mRemoteServices.generateBag().enqueue(new Callback<Bag>() {
            @Override
            public void onResponse(Call<Bag> call, Response<Bag> response) {
                if (null != response && null != response.body()) {
                    Toast.makeText(getContext(), "New bag created:\n" + response.body(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Bag> call, Throwable t) {
                Toast.makeText(MyApp.getInstance(), "Some error occurred!\nError description:"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void deleteAllRecords() {
        mRemoteServices.deleteAllBags().enqueue(new Callback<DeleteResponse>() {
            @Override
            public void onResponse(Call<DeleteResponse> call, Response<DeleteResponse> response) {
                if(null != response && null != response.body()) {
                    Toast.makeText(getContext(), response.body().getRowsDeleted()+" Rows successfully deleted!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.e(TAG, "Null response received for delete bags api!!");
                }
            }

            @Override
            public void onFailure(Call<DeleteResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Some error occurred!\nError description:"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
