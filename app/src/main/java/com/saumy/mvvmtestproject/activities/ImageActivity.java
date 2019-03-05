package com.saumy.mvvmtestproject.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.databinding.ActivityImageBinding;

public class ImageActivity extends AppCompatActivity implements ImageFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityImageBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_image);
        binding.setListener(this);
    }

    @Override
    public void oneOneClicked() {
        Toast.makeText(this, "11", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void oneTwoClicked() {
        Toast.makeText(this, "12", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void oneThreeClicked() {
        Toast.makeText(this, "13", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void twoOneClicked() {
        Toast.makeText(this, "21", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void twoTwoClicked() {
        Toast.makeText(this, "22", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void twoThreeClicked() {
        Toast.makeText(this, "23", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void threeOneClicked() {
        Toast.makeText(this, "31", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void threeTwoClicked() {
        Toast.makeText(this, "32", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void threeThreeClicked() {
        Toast.makeText(this, "33", Toast.LENGTH_SHORT).show();

    }
}
