package com.example.nasaapod;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nasaapod.databinding.CardItemBinding;
import com.example.nasaapod.data.model.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ApodRecyclerAdapter extends RecyclerView.Adapter<ApodRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<PlaceholderItem> imageItem;

    public ApodRecyclerAdapter(Context context, List<PlaceholderItem> items) {
        this.context = context;
        this.imageItem = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(CardItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = imageItem.get(position);
        holder.mTitle.setText(holder.mItem.id);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTitle;
        public PlaceholderItem mItem;

        public ViewHolder(CardItemBinding binding) {
            super(binding.getRoot());
            mTitle = binding.itemTitle;
        }
    }

    @Override
    public int getItemCount() {
        return imageItem.size();
    }
}