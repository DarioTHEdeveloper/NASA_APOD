package com.example.nasaapod;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nasaapod.data.model.ApodImage;
import com.example.nasaapod.databinding.CardItemBinding;
import com.example.nasaapod.data.model.PlaceholderItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ApodRecyclerAdapter extends RecyclerView.Adapter<ApodRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<ApodImage> imageItem;

    public ApodRecyclerAdapter(Context context, List<ApodImage> items) {
        this.context = context;
        this.imageItem = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(CardItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ApodImage item = imageItem.get(position);
        holder.mTitle.setText(item.title);

        Glide.with(context)
                .load(item.hdurl)
                .into(holder.mImage);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mTitle;
        public final ImageView mImage;

        public ViewHolder(CardItemBinding binding) {
            super(binding.getRoot());
            mTitle = binding.itemTitle;
            mImage = binding.itemImage;
        }
    }

    @Override
    public int getItemCount() {
        return imageItem.size();
    }

    void setImagelist (List<ApodImage> imagelist) {
        imageItem = imagelist;
    }
}