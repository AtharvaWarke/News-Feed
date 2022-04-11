package com.example.android.newsfeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private final ArrayList<data> mData;
    private final Context mContext;
    private final onAdapterItemClickListener mOnAdapterItemClickListener;


    public RecyclerViewAdapter(@NonNull Context context, ArrayList<data> data, onAdapterItemClickListener onAdapterItemClickListener) {
        this.mContext = context;
        this.mOnAdapterItemClickListener = onAdapterItemClickListener;
        this.mData = data;
    }

    @NonNull
    //Single card which is to be inflated
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view, mOnAdapterItemClickListener);

    }


    //What to add in the textview or in card
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        data data = mData.get(position);
        holder.sourceTextView.setText(data.getSource());
        holder.descriptionTextView.setText(data.getDescription());
        holder.titleTextView.setText(data.getTitle());
        Glide.with(holder.imageView).load(data.getUrlToImage()).into(holder.imageView);
//        Intent intent = new Intent(RecyclerViewAdapter.this, NewsDisplayActivity.class);
//        intent.putExtra("urlll", data.getUrl());
    }

    //How many items
    @Override
    public int getItemCount() {
        return mData.size();
    }


    //What do we want from the card (single card that is to be inflated) eg. TextView, image, EditText
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView titleTextView;
        private final TextView sourceTextView;
        private final TextView descriptionTextView;
        private final ImageView imageView;
        onAdapterItemClickListener mOnAdapterItemClickListener;

        public ViewHolder(@NonNull View itemView, onAdapterItemClickListener onAdapterItemClickListener) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            sourceTextView = itemView.findViewById(R.id.sourceTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            imageView = itemView.findViewById(R.id.imageView);
            mOnAdapterItemClickListener = onAdapterItemClickListener;
            itemView.setOnClickListener(this);
//            this.onAdapterItemClickListener = onAdapterItemClickListener;
        }


        @Override
        public void onClick(View v) {
            mOnAdapterItemClickListener.onItemClick(getAdapterPosition());

        }
    }
}
