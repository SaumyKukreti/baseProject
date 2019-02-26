package com.saumy.mvvmtestproject.fragments.searchfragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.saumy.mvvmtestproject.R;
import com.saumy.mvvmtestproject.databinding.LayoutBagBinding;
import com.saumy.mvvmtestproject.models.Bag;

import java.util.List;

/**
 * Created by saumy on 2/25/2019.
 */

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.SearchViewHolder> {

    private LayoutInflater mInflater;

    private List<Bag> mBagList;
    private LayoutBagBinding bagBinding;

    public SearchResultsAdapter(Context context, List<Bag> bags) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mBagList = bags;
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        bagBinding = DataBindingUtil.inflate(mInflater, R.layout.layout_bag, parent, false);

        return new SearchViewHolder(bagBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        bagBinding.setModel(mBagList.get(position));
    }

    @Override
    public int getItemCount() {
        return (null != mBagList) ? mBagList.size() : 0;
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {

        public SearchViewHolder(View itemView) {
            super(itemView);
        }
    }
}
