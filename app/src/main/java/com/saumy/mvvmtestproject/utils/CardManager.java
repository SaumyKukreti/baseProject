package com.saumy.mvvmtestproject.utils;

import com.saumy.mvvmtestproject.constants.AppConstants;
import com.saumy.mvvmtestproject.models.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saumy on 12/16/2018.
 */

public class CardManager {

    public static List<Card> getListOfCards(){

        ArrayList<Card> listOfCards= new ArrayList<>();

        listOfCards.add(new Card(AppConstants.PASSPORT_ID,AppConstants.PASSPORT));

        return listOfCards;
    }

}
