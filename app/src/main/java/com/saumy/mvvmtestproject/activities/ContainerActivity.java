package com.saumy.mvvmtestproject.activities;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Transition;
import android.util.Log;

import com.saumy.mvvmtestproject.fragments.dashboardfragment.DashboardFragment;
import com.saumy.mvvmtestproject.MyApp;
import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.databinding.ActivityContainerBinding;
import com.saumy.mvvmtestproject.retrofit.RemoteServices;

import javax.inject.Inject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContainerActivity extends AppCompatActivity {

    private static final String TAG = ContainerActivity.class.getSimpleName();
    ActivityContainerBinding mActivityContainerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityContainerBinding = DataBindingUtil.setContentView(this, R.layout.activity_container);
        ((MyApp) getApplicationContext()).getComponent().inject(this);
        addHomeFragment();
    }

    /**
     * This method adds the home fragment to the view
     */
    private void addHomeFragment() {
        //Creating a dashboard fragment
        DashboardFragment dashboardFragment = DashboardFragment.newInstance();
        pushFragment(dashboardFragment, true, false);
    }

    public void pushFragment(Fragment fragment, boolean add, boolean addToBackStack) {
        if (null != fragment && null != getSupportFragmentManager()) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            if (add)
                transaction.add(R.id.fragment_container, fragment);
            else
                transaction.replace(R.id.fragment_container, fragment);

            if (addToBackStack)
                transaction.addToBackStack(fragment.getClass().getSimpleName());

            transaction.commitAllowingStateLoss();
        } else {
            Log.e(TAG, "Passed fragment is null!");
        }
    }

    public void openFragment() {

    }
}
