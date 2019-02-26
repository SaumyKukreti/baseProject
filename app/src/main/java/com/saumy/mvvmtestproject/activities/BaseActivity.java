package com.saumy.mvvmtestproject.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by saumy on 2/26/2019.
 */

public class BaseActivity extends AppCompatActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    public void pushFragment(int view, Fragment fragment, boolean add, boolean addToBackStack) {
        if (null != fragment && null != getSupportFragmentManager()) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            if (add)
                transaction.add(view, fragment);
            else
                transaction.replace(view, fragment);

            if (addToBackStack)
                transaction.addToBackStack(fragment.getClass().getSimpleName());

            transaction.commitAllowingStateLoss();
        } else {
            Log.e(TAG, "Passed fragment is null!");
        }
    }
}
