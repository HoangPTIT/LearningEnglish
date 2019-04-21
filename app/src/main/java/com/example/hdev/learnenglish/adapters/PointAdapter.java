package com.example.hdev.learnenglish.adapters;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.hdev.learnenglish.R;
import com.example.hdev.learnenglish.adapters.PointAdapter.PointViewHolder;
import java.util.ArrayList;
import java.util.List;

public class PointAdapter extends RecyclerView.Adapter<PointViewHolder> {

    List<String> mPoints = new ArrayList<>();

    public PointAdapter(final List<String> topics) {
        mPoints = topics;
    }

    @NonNull
    @Override
    public PointViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_point, parent, false);
        return new PointViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PointViewHolder holder, int position) {
        // Find Image from drawable by name.;
        holder.mText_point_item.setText(mPoints.get(position));
    }

    @Override
    public int getItemCount() {
        return mPoints.size();
    }

    static class PointViewHolder extends RecyclerView.ViewHolder {

        private TextView mText_point_item;

        PointViewHolder(@NonNull final View itemView) {
            super(itemView);
            mText_point_item = itemView.findViewById(R.id.text_point_item);
        }
    }
}
