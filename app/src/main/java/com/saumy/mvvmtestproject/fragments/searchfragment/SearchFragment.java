package com.saumy.mvvmtestproject.fragments.searchfragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saumy.mvvmtestproject.MyApp;
import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.constants.AppConstants;
import com.saumy.mvvmtestproject.databinding.FragmentSearchBinding;
import com.saumy.mvvmtestproject.retrofit.RemoteServices;

import javax.inject.Inject;

public class SearchFragment extends Fragment implements SearchFragmentListener {

    private FragmentSearchBinding mFragmentSearchBinding;
    private AppConstants.SEARCH_BY mSearchBy;
    private SearchViewModel mViewModel;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Inject
    RemoteServices mRemoteServices;


    public static SearchFragment newInstance(AppConstants.SEARCH_BY search_by) {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        args.putSerializable(AppConstants.searchByKey, search_by);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSearchBy = (AppConstants.SEARCH_BY) getArguments().getSerializable(AppConstants.searchByKey);
        }

        ((MyApp)getActivity().getApplication()).getComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentSearchBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search,
                container, false);
        mFragmentSearchBinding.setListener(this);
        mViewModel = ViewModelProviders.of(this).get(SearchViewModel.class);
        return mFragmentSearchBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }

    @Override
    public void startSearch() {
        String searchText = mFragmentSearchBinding.editSearch.getText().toString();
        if(mSearchBy == AppConstants.SEARCH_BY.SEARCH_BY_ID)
        mViewModel.getBagsById(mRemoteServices, searchText);
        else
            mViewModel.getBagsByName(mRemoteServices, searchText);
    }
}
