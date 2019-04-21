package com.example.hdev.learnenglish.dialog;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.example.hdev.learnenglish.Constants;
import com.example.hdev.learnenglish.R;
import java.util.Objects;

public class TopicOptionDialog extends DialogFragment implements View.OnClickListener {

    @RequiresApi(api = VERSION_CODES.KITKAT)
    @Override
    public void onStart() {
        super.onStart();
        setSizeDialogScreen();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_topic_option, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.buttonLearning: {
                callBackData(Constants.LEARNING);
                break;
            }

            case R.id.buttonTraining: {
                callBackData(Constants.TRAINING);
                break;
            }

            case R.id.buttonTesting: {
                callBackData(Constants.TESTING);
                break;
            }

            case R.id.imageBack: {
                callBackData(Constants.CANCEL);
                break;
            }
        }
    }

    private void initComponents(View view) {
        final Button buttonLearning = view.findViewById(R.id.buttonLearning);
        final Button buttonTraining = view.findViewById(R.id.buttonTraining);
        final Button buttonTesting = view.findViewById(R.id.buttonTesting);
        final ImageView imageBack = view.findViewById(R.id.imageBack);

        buttonLearning.setOnClickListener(this);
        buttonTraining.setOnClickListener(this);
        buttonTesting.setOnClickListener(this);
        imageBack.setOnClickListener(this);
    }

    @RequiresApi(api = VERSION_CODES.KITKAT)
    private void setSizeDialogScreen() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Objects.requireNonNull(getActivity()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int widthDialog = (int) (0.8 * displayMetrics.widthPixels);
        int heightDialog = (int) (0.5 * displayMetrics.heightPixels);
        Objects.requireNonNull(getDialog().getWindow()).setLayout(widthDialog, heightDialog);
    }

    private void callBackData(String data) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.BUNDLE_OPTION, data);
        intent.putExtras(bundle);
        if (getTargetFragment() != null) {
            getTargetFragment().onActivityResult(Constants.REQUEST_CODE_TOPIC, RESULT_OK, intent);
        }
    }
}
