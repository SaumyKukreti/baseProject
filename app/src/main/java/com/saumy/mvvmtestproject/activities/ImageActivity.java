package com.saumy.mvvmtestproject.activities;

import android.databinding.DataBindingUtil;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.databinding.ActivityImageBinding;

public class ImageActivity extends AppCompatActivity implements ImageFragmentListener {

    private ActivityImageBinding binding;
    private boolean makeUpState;
    private boolean sorterOneState;
    private boolean sorterTwoState;
    private boolean lineState;
    private boolean metroState;
    private boolean levelState;
    private boolean tunnelState;
    private boolean checckInState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = DataBindingUtil.setContentView(this, R.layout.activity_image);
        binding.setListener(this);

        Display display = getWindowManager(). getDefaultDisplay();
        Point size = new Point();
        display. getSize(size);

        int width = size. x;
        int height = size. y;

        Log.e("aiefh", String.valueOf(width));
        Log.e("aiefh", String.valueOf(height));

        binding.imageBhs.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("aiefh", String.valueOf(event.getX()));
                Log.e("aiefh", String.valueOf(event.getY()));
                return false;
            }
        });

    }

    @Override
    public void makeUpClicked() {
        changeDrawable(binding.buttonMakeUp,makeUpState);
        makeUpState = !makeUpState;
    }

    private void changeDrawable(Button button , boolean current){

        if(current){
            button.setBackgroundDrawable(getDrawable(R.drawable.black_outline));
        }
        else{
            button.setBackgroundDrawable(getDrawable(R.drawable.white_outline));
        }
    }

    @Override
    public void sorterOneClicked() {
        changeDrawable(binding.buttonSorter1,sorterOneState);
        sorterOneState = !sorterOneState;
    }

    @Override
    public void sorterTwoClicked() {
        changeDrawable(binding.buttonSorter2,sorterTwoState);
        sorterTwoState = !sorterTwoState;
    }

    @Override
    public void lineClicked() {
        changeDrawable(binding.buttonLineOne,lineState);
        lineState = !lineState;
    }

    @Override
    public void metroClicked() {
        changeDrawable(binding.buttonMetro,metroState);
        metroState = !metroState;
    }

    @Override
    public void buttonLevelCliked() {
        changeDrawable(binding.buttonLevel3,levelState);
        levelState =!levelState;
    }

    @Override
    public void tunnelClicked() {
        changeDrawable(binding.buttonTunnel,tunnelState);
        tunnelState =!tunnelState;
    }

    @Override
    public void checkInClicked() {
        changeDrawable(binding.buttonCheckIn,checckInState);
        checckInState =!checckInState;
    }
}
