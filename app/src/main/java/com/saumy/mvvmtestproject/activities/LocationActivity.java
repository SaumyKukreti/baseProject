package com.saumy.mvvmtestproject.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.data.LocationManager;
import com.saumy.mvvmtestproject.databinding.ActivityLocationBinding;
import com.saumy.mvvmtestproject.models.SubLocation;
import com.saumy.mvvmtestproject.utils.Utils;

import java.util.List;

/**
 * Created by saumy on 12/22/2018.
 */

public class LocationActivity extends AppCompatActivity {

    private ActivityLocationBinding mActivityLocationBinding;
    private String selectedLocation;
    private String selectedSubLocation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLocationBinding = DataBindingUtil.setContentView(this, R.layout.activity_location);

        setUpLocationSpinner();
    }


    private void setUpLocationSpinner() {
        List<String> listOfLocationNames = LocationManager.getListOfLocationNames();
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,listOfLocationNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner
        mActivityLocationBinding.spinnerLocation.setAdapter(arrayAdapter);
        mActivityLocationBinding.spinnerLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                setUpSubLocationSpinner(LocationManager.getListOfLocation().get(position).getSbLocationList());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Do nothing
            }
        });

        //Set first item

        mActivityLocationBinding.spinnerLocation.setSelection(0);
        setUpSubLocationSpinner(LocationManager.getListOfLocation().get(0).getSbLocationList());
    }

    /**
     * This method sets up the list for sub location
     * @param sbLocationList
     */
    private void setUpSubLocationSpinner(final List<SubLocation> sbLocationList) {

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,sbLocationList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Setting the ArrayAdapter data on the Spinner
        mActivityLocationBinding.spinnerSubLocation.setAdapter(arrayAdapter);

        mActivityLocationBinding.spinnerSubLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedLocation = sbLocationList.get(position).getLocationId();
                selectedSubLocation = sbLocationList.get(position).getSubLocationId();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Do nothing
            }
        });

        mActivityLocationBinding.spinnerSubLocation.setSelection(0);

    }
}
