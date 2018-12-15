package com.saumy.mvvmtestproject.dagger;

import com.saumy.mvvmtestproject.activities.ContainerActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by saumy on 10/17/2018.
 */

@Singleton
@Component(modules = AppModule.class)
public interface ApplicationComponent {

    void inject(ContainerActivity containerActivity);
}
