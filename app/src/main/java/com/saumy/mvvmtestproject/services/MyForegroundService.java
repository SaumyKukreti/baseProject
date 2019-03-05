package com.saumy.mvvmtestproject.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

import com.saumy.mvvmtestproject.MyApp;
import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.activities.NavigationDrawerActivity;
import com.saumy.mvvmtestproject.models.Bag;
import com.saumy.mvvmtestproject.retrofit.RemoteServices;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by saumy on 3/1/2019.
 */

public class MyForegroundService extends Service{

    @Inject
    RemoteServices mRemoteServices;

    @Override
    public void onCreate() {
        super.onCreate();
        MyApp.getInstance().getComponent().inject(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "afe")
                .setSmallIcon(R.drawable.ic_menu_camera)
                .setContentTitle("Title")
                .setContentText("Content")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        startForeground(123, mBuilder.build());
        new Thread(new Runnable() {
            @Override
            public void run() {
                int c =0;

                while(c<10000000)
                {
                    mRemoteServices.generateBag().enqueue(new Callback<Bag>() {
                        @Override
                        public void onResponse(Call<Bag> call, Response<Bag> response) {
                            Log.e("tag","aowefjaoiejfawf0");
                        }

                        @Override
                        public void onFailure(Call<Bag> call, Throwable t) {
                            Log.e("tag","aowefjaoiejfawf0");

                        }
                    });
                    Log.e("TAG","Hojaewfojeofja;weof");
                    try {
                        Thread.sleep(100);
                        NotificationManagerCompat.from(MyApp.getInstance()).notify(11,mBuilder.build());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        return START_NOT_STICKY;
    }
}
