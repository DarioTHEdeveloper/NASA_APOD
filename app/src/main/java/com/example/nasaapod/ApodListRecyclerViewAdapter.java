package com.example.nasaapod;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nasaapod.databinding.CardItemBinding;
import com.example.nasaapod.placeholder.PlaceholderContent.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ApodListRecyclerViewAdapter extends RecyclerView.Adapter<ApodListRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderItem> mValues;

    public ApodListRecyclerViewAdapter(List<PlaceholderItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(CardItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitle.setText(holder.mItem.id);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTitle;
        public PlaceholderItem mItem;

        public ViewHolder(CardItemBinding binding) {
            super(binding.getRoot());
            mTitle = binding.itemTitle;
        }
    }
}