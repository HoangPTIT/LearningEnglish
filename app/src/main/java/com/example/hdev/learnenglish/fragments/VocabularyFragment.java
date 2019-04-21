package com.example.hdev.learnenglish.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.hdev.learnenglish.Constants;
import com.example.hdev.learnenglish.R;
import com.example.hdev.learnenglish.adapters.PointAdapter;
import com.example.hdev.learnenglish.adapters.TopicAdapter;
import com.example.hdev.learnenglish.dialog.TopicOptionDialog;
import com.example.hdev.learnenglish.interfaces.TopicItemCallback;
import com.example.hdev.learnenglish.models.Topic;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class VocabularyFragment extends Fragment implements TopicItemCallback {

    private List<Topic> mTopics = new ArrayList<>();

    private List<String> TopicImageNames = new ArrayList<>();

    private List<String> mPoints = Arrays.asList("250", "300", "350", "450", "500", "600", "750", "800+");

    private RecyclerView mRecycler_topic;

    private RecyclerView mRecycler_point;

    private TopicOptionDialog topicOptionDialog = new TopicOptionDialog();

    public VocabularyFragment() {
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vocabulary, container, false);
        bindingView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initComponents();
    }

    @SuppressLint("CommitTransaction")
    @RequiresApi(api = VERSION_CODES.KITKAT)
    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if (data != null) {
            switch (Objects
                    .requireNonNull(Objects.requireNonNull(data.getExtras()).getString(Constants.BUNDLE_OPTION))) {
                case Constants.LEARNING: {
                    topicOptionDialog.dismiss();
                    break;
                }

                case Constants.TRAINING: {
                    // TODO: Go to training screen
                    Objects.requireNonNull(getActivity()).getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_layout, new VocabularyDetailFragment())
                            .addToBackStack("")
                            .commit();
                    topicOptionDialog.dismiss();
                    break;
                }

                case Constants.TESTING: {
                    topicOptionDialog.dismiss();
                    break;
                }

                case Constants.CANCEL: {
                    topicOptionDialog.dismiss();
                }
            }
        }
    }

    @RequiresApi(api = VERSION_CODES.KITKAT)
    @Override
    public void topicItemClick(final Topic topic) {
        FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
        topicOptionDialog.setTargetFragment(this, Constants.REQUEST_CODE_TOPIC);
        topicOptionDialog.show(fragmentManager, "");
    }

    private void bindingView(View view) {
        mRecycler_topic = view.findViewById(R.id.recycler_topic);
        mRecycler_point = view.findViewById(R.id.recycler_point);
    }

    private void initData() {
        mTopics.add(
                new Topic(getResources().getString(R.string.ic_topic_1), getResources().getString(R.string.topic_1),
                        0));
        mTopics.add(
                new Topic(getResources().getString(R.string.ic_topic_2), getResources().getString(R.string.topic_2),
                        0));
        mTopics.add(
                new Topic(getResources().getString(R.string.ic_topic_3), getResources().getString(R.string.topic_3),
                        0));
        mTopics.add(
                new Topic(getResources().getString(R.string.ic_topic_4), getResources().getString(R.string.topic_4),
                        0));
        mTopics.add(
                new Topic(getResources().getString(R.string.ic_topic_5), getResources().getString(R.string.topic_5),
                        0));
        mTopics.add(
                new Topic(getResources().getString(R.string.ic_topic_6), getResources().getString(R.string.topic_6),
                        0));
        mTopics.add(
                new Topic(getResources().getString(R.string.ic_topic_7), getResources().getString(R.string.topic_7),
                        0));
        mTopics.add(
                new Topic(getResources().getString(R.string.ic_topic_8), getResources().getString(R.string.topic_8),
                        0));
        mTopics.add(
                new Topic(getResources().getString(R.string.ic_topic_9), getResources().getString(R.string.topic_9),
                        0));
    }

    private void initComponents() {
        displayTopics(Constants.DISPLAY_LIST);
        displayPoint();
    }

    public void displayTopics(int topicStyleDisplay) {
        final TopicAdapter topicAdapter = new TopicAdapter(mTopics, this);
        LinearLayoutManager layoutManager = null;
        switch (topicStyleDisplay) {
            case Constants.DISPLAY_LIST: {
                layoutManager = new LinearLayoutManager(getActivity());
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                break;
            }
            case Constants.DISPLAY_GRID: {
                layoutManager = new GridLayoutManager(getActivity(), Constants.GRID_SPAN_COUNT);
                break;
            }
        }
        if (layoutManager != null && mRecycler_topic != null) {
            mRecycler_topic.setLayoutManager(layoutManager);
            mRecycler_topic.setAdapter(topicAdapter);
        }
    }

    private void displayPoint() {
        // Point
        final PointAdapter pointAdapter = new PointAdapter(mPoints);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        layoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecycler_point.setLayoutManager(layoutManager1);
        mRecycler_point.setAdapter(pointAdapter);
    }
}
