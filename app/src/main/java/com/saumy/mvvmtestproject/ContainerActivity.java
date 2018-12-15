package com.saumy.mvvmtestproject;

import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.saumy.mvvmtestproject.databinding.ActivityContainerBinding;

public class ContainerActivity extends AppCompatActivity {

    ActivityContainerBinding mActivityContainerBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_container);

        mActivityContainerBinding = DataBindingUtil.setContentView(this, R.layout.activity_container);

        addHomeFragment();
    }

    /**
     * This method adds the home fragment to the view
     */
    private void addHomeFragment() {
        //Creating a dashboard fragment
        DashboardFragment dashboardFragment = DashboardFragment.newInstance();
        this.getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,dashboardFragment).commit();
    }
}
