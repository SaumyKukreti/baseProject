package com.saumy.mvvmtestproject.fragments.findbaggagefragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.saumy.mvvmtestproject.MyApp;
import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.activities.ContainerActivity;
import com.saumy.mvvmtestproject.constants.AppConstants;
import com.saumy.mvvmtestproject.databinding.FragmentFindBaggageBinding;
import com.saumy.mvvmtestproject.fragments.searchfragment.SearchFragment;
import com.saumy.mvvmtestproject.models.Bag;
import com.saumy.mvvmtestproject.retrofit.RemoteServices;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FindBaggageFragment extends Fragment implements FindBaggageListener{


    @Inject
    RemoteServices mRemoteServices;

    private FindBaggageListener mListener;

    public FindBaggageFragment() {
        // Required empty public constructor
    }

    public static FindBaggageFragment newInstance() {
        FindBaggageFragment fragment = new FindBaggageFragment();
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
        FragmentFindBaggageBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_find_baggage,
                container, false);
        binding.setListener(this);
        return binding.getRoot();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FindBaggageListener) {
            mListener = (FindBaggageListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void searchBagByIdClicked() {
        startSearch(AppConstants.SEARCH_BY.SEARCH_BY_ID);
    }

    /**
     * This method is used to open search fragment
     * @param searchById
     */
    private void startSearch(AppConstants.SEARCH_BY searchById) {
        ((ContainerActivity)getActivity()).pushFragment(SearchFragment.newInstance(searchById),true,true);
    }

    @Override
    public void searchBagByNameClicked() {
        startSearch(AppConstants.SEARCH_BY.SEARCH_BY_NAME);
    }

    @Override
    public void generateNewRecord() {
        mRemoteServices.generateBag().enqueue(new Callback<Bag>() {
            @Override
            public void onResponse(Call<Bag> call, Response<Bag> response) {
                if(null != response && null != response.body()){
                    Toast.makeText(getContext(), "New bag created:\n"+response.body(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Bag> call, Throwable t) {

            }
        });
    }
}
