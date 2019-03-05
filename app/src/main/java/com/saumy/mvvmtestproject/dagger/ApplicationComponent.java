package com.saumy.mvvmtestproject.dagger;

import com.saumy.mvvmtestproject.activities.NavigationDrawerActivity;
import com.saumy.mvvmtestproject.fragments.ChartFragment;
import com.saumy.mvvmtestproject.fragments.findbaggagefragment.FindBaggageFragment;
import com.saumy.mvvmtestproject.fragments.managefragment.ManageFragment;
import com.saumy.mvvmtestproject.fragments.searchfragment.SearchFragment;
import com.saumy.mvvmtestproject.services.MyForegroundService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by saumy on 10/17/2018.
 */

@Singleton
@Component(modules = AppModule.class)
public interface ApplicationComponent {

    void inject(SearchFragment searchFragment);
    void inject(FindBaggageFragment findBaggageFragment);
    void inject(NavigationDrawerActivity navigationDrawerActivity);
    void inject(ManageFragment manageFragment);
    void inject(ChartFragment chartFragment);
    void inject(MyForegroundService myForegroundService);
}
