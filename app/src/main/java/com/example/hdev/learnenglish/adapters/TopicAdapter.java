package com.example.hdev.learnenglish.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hdev.learnenglish.R;
import com.example.hdev.learnenglish.adapters.TopicAdapter.TopicViewHolder;
import com.example.hdev.learnenglish.interfaces.TopicItemCallback;
import com.example.hdev.learnenglish.models.Topic;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicViewHolder> {

    private List<Topic> mTopics;

    private TopicItemCallback listener;

    public TopicAdapter(final List<Topic> topics, TopicItemCallback topicItemCallback) {
        mTopics = topics;
        listener = topicItemCallback;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_topic, parent, false);
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        // Find Image from drawable by name.
        holder.bind(mTopics.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }

    static class TopicViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImage_item;

        private TextView mText_topic;

        private ImageView mImage_status;

        TopicViewHolder(@NonNull final View itemView) {
            super(itemView);
            mImage_item = itemView.findViewById(R.id.image_item);
            mText_topic = itemView.findViewById(R.id.text_topic);
            mImage_status = itemView.findViewById(R.id.image_status);
        }

        void bind(final Topic topic, final TopicItemCallback listener) {
            mImage_item.setImageResource(getResourceImageByName(topic.getPicture()));
            mText_topic.setText(topic.getTopic());
            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(final View v) {
                    listener.topicItemClick(topic);
                }
            });
        }

        private int getResourceImageByName(String name) {
            return itemView.getContext().getResources()
                    .getIdentifier(name, "drawable", itemView.getContext().getPackageName());
        }
    }
}
