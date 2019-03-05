package com.saumy.mvvmtestproject.fragments.dashboardfragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.activities.BaseActivity;
import com.saumy.mvvmtestproject.activities.ImageActivity;
import com.saumy.mvvmtestproject.activities.NavigationDrawerActivity;
import com.saumy.mvvmtestproject.databinding.FragmentDashboardBinding;
import com.saumy.mvvmtestproject.fragments.ChartFragment;
import com.saumy.mvvmtestproject.fragments.findbaggagefragment.FindBaggageFragment;
import com.saumy.mvvmtestproject.fragments.managefragment.ManageFragment;

public class DashboardFragment extends Fragment implements DashboardFragmentListener {

    private static final String TAG = DashboardFragment.class.getSimpleName();
    FragmentDashboardBinding mFragmentDashboardBinding;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DashboardFragment.
     */
    public static DashboardFragment newInstance() {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        //Pass the arguments here
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //Set the arguments here
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mFragmentDashboardBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_dashboard, container, false);

        mFragmentDashboardBinding.setListener(this);
        return mFragmentDashboardBinding.getRoot();
    }

    @Override
    public void findBaggageClicked() {
        //Going to findBaggageFragment
        ((BaseActivity) getContext()).pushFragment(R.id.fragment_container,FindBaggageFragment.newInstance(),true,true);
    }

    @Override
    public void manageFragmentClicked() {
        ((BaseActivity) getContext()).pushFragment(R.id.fragment_container, ManageFragment.newInstance(),true,true);
    }

    @Override
    public void chartFragmentClicked() {
        ((BaseActivity) getContext()).pushFragment(R.id.fragment_container, ChartFragment.newInstance(),true,true);
    }

    @Override
    public void scadaClicked() {
        startActivity(new Intent(getContext(), ImageActivity.class));
    }
}
