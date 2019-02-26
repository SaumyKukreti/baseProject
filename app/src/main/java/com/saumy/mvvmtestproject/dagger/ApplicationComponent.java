package com.saumy.mvvmtestproject.dagger;

import com.saumy.mvvmtestproject.activities.ContainerActivity;
import com.saumy.mvvmtestproject.fragments.findbaggagefragment.FindBaggageFragment;
import com.saumy.mvvmtestproject.fragments.searchfragment.SearchFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by saumy on 10/17/2018.
 */

@Singleton
@Component(modules = AppModule.class)
public interface ApplicationComponent {

    void inject(ContainerActivity containerActivity);
    void inject(SearchFragment searchFragment);
    void inject(FindBaggageFragment findBaggageFragment);
}
