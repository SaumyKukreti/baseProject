package com.saumy.mvvmtestproject.fragments.homefragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.databinding.FragmentDashboardBinding;
import com.saumy.mvvmtestproject.models.Card;
import com.saumy.mvvmtestproject.utils.CardManager;

import java.util.List;

import static android.databinding.DataBindingUtil.inflate;

public class HomeFragment extends Fragment implements HomeFragmentClickListener{

    FragmentDashboardBinding mFragmentDashboardBinding;
    private List<Card> mListOfCards;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        //Pass the arguments here
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //Set the arguments here
        }

        mListOfCards = CardManager.getListOfCards();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initialise();
    }

    /**
     * This method is used to initialise the screen
     */
    private void initialise() {
        setUpSpinner();
    }

    /**
     * This method is used to set up spinner
     */
    private void setUpSpinner() {
//        mFragmentDashboardBinding.spinnerCard.setAdapter(new SimpleAdapter(this, mListOfCards));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mFragmentDashboardBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragment_dashboard, container, false);
        return mFragmentDashboardBinding.getRoot();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }



    /******************************Click Listners*******************************/
    @Override
    public void continueClicked() {

    }
}
