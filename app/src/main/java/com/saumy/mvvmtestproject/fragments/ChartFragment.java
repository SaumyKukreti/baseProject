package com.saumy.mvvmtestproject.fragments;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.saumy.mvvmtestproject.MyApp;
import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.activities.BaseActivity;
import com.saumy.mvvmtestproject.databinding.FragmentChartBinding;
import com.saumy.mvvmtestproject.fragments.searchfragment.SearchFragment;
import com.saumy.mvvmtestproject.models.Bag;
import com.saumy.mvvmtestproject.retrofit.RemoteServices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChartFragment extends Fragment implements OnChartValueSelectedListener {


    @Inject
    RemoteServices mRemoteServices;

    private FragmentChartBinding mFragmentChartBinding;
    private BarChart chart;
    public ChartFragment() {
        // Required empty public constructor
    }

    public static ChartFragment newInstance() {
        ChartFragment fragment = new ChartFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }

        MyApp.getInstance().getComponent().inject(this);
        getData();
    }

    /**
     * This method is used to get data from the api and organise them into different status
     */
    private void getData() {
        mRemoteServices.getAllBags().enqueue(new Callback<List<Bag>>() {
            @Override
            public void onResponse(Call<List<Bag>> call, Response<List<Bag>> response) {
                if(null != response && null != response.body()){
                    HashMap<String, Integer> map = extractDataFromResponse(response.body());
                    addValuesToChart(map);
                }
                else{
                    showErrorText(true);
                }
            }

            @Override
            public void onFailure(Call<List<Bag>> call, Throwable t) {
                showErrorText(true);
            }
        });
    }

    private void showErrorText(boolean showErrorText) {
        mFragmentChartBinding.contentLoader.setVisibility(View.GONE);
        mFragmentChartBinding.textNoResultAvailable.setVisibility(View.VISIBLE);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mFragmentChartBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_chart, container, false);
        return mFragmentChartBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    private ArrayList<String> keys;

    private void addValuesToChart(HashMap<String, Integer> map) {
        initialiseChart();

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        keys = new ArrayList<>(map.keySet());

        for(int i =0; i<keys.size();i++)
            barEntries.add(new BarEntry(i, map.get(keys.get(i))));

        BarDataSet barDataSet = new BarDataSet(barEntries, "Baggage details");
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        BarData barData = new BarData(barDataSet);
        barData.setBarWidth(0.5f);

        if(null != chart)
        chart.setData(barData);

        XAxis xaxis = chart.getXAxis();
        xaxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xaxis.setLabelRotationAngle(45);
        xaxis.mLabelRotatedHeight = 120;
        xaxis.setTextSize(13f);
        xaxis.setTextColor(getResources().getColor(R.color.colorPrimary));
        xaxis.setDrawAxisLine(true);
        xaxis.setDrawGridLines(false);
        xaxis.setGranularity(1);
        xaxis.setValueFormatter(new MyAxisFormatter(keys));

        configureChart();
    }

    private HashMap<String, Integer> extractDataFromResponse(List<Bag> body) {
        HashMap<String, Integer> map = new HashMap<>();
        for(Bag bag: body){
            String status = bag.getStatus();
            if(map.containsKey(status)){
                map.put(status, map.get(status)+1);
            }
            else{
                map.put(status, 1);
            }
        }
        return map;
    }

    private void configureChart() {
        chart.setDrawBarShadow(false);
        chart.setDrawValueAboveBar(true);

        chart.getDescription().setEnabled(false);
        // drawn
        chart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        chart.setPinchZoom(false);

        chart.setDrawGridBackground(false);

        chart.setFitBars(true);
        // chart.setDrawYLabels(false);
        chart.setVisibility(View.VISIBLE);
        mFragmentChartBinding.contentLoader.setVisibility(View.GONE);
        chart.setVisibility(View.VISIBLE);
    }

    private void initialiseChart() {
        chart = mFragmentChartBinding.chart1;
        chart.setOnChartValueSelectedListener(this);
    }


    @Override
    public void onValueSelected(Entry e, Highlight h) {
        ((BaseActivity)getContext()).pushFragment(R.id.fragment_container, SearchFragment.newInstance(null, keys.get((int) e.getX())),true,true);
    }

    @Override
    public void onNothingSelected() {

    }

    class MyAxisFormatter extends ValueFormatter{

        private List<String> mStringList;
        public MyAxisFormatter(List<String> listOfStatus) {
            mStringList = listOfStatus;
        }


        @Override
        public String getFormattedValue(float value) {
            return mStringList.get((int) value);
        }
    }
}
