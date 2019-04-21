package com.example.hdev.learnenglish.fragments;

import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hdev.learnenglish.R;
import java.util.Objects;

public class VocabularyDetailFragment extends Fragment implements OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vocabulary_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initComponents(view);
        displayQuestion();
    }

    @RequiresApi(api = VERSION_CODES.KITKAT)
    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.textAnswe1: {
                break;
            }

            case R.id.textAnswe2: {
                break;
            }

            case R.id.textAnswe3: {
                break;
            }

            case R.id.textAnswe4: {
                break;
            }

            case R.id.textAnswe5: {
                break;
            }

            case R.id.textAnswe6: {
                break;
            }

            case R.id.textAnswe7: {
                break;
            }

            case R.id.buttonContinue: {
                continue_question();
                break;
            }

            case R.id.imageBackDetail: {
                Objects.requireNonNull(getActivity()).getSupportFragmentManager().popBackStack();
                break;
            }
        }
    }

    private void initComponents(View view) {
        final TextView textAnswe1 = view.findViewById(R.id.textAnswe1);
        final TextView textAnswe2 = view.findViewById(R.id.textAnswe2);
        final TextView textAnswe3 = view.findViewById(R.id.textAnswe3);
        final TextView textAnswe4 = view.findViewById(R.id.textAnswe4);
        final TextView textAnswe5 = view.findViewById(R.id.textAnswe5);
        final TextView textAnswe6 = view.findViewById(R.id.textAnswe6);
        final TextView textAnswe7 = view.findViewById(R.id.textAnswe7);
        final Button buttonContinue = view.findViewById(R.id.buttonContinue);
        final ImageView imagBackDetail = view.findViewById(R.id.imageBackDetail);
        final TextView textTitleDetail = view.findViewById(R.id.textTitleDetaill);

        textAnswe1.setOnClickListener(this);
        textAnswe2.setOnClickListener(this);
        textAnswe3.setOnClickListener(this);
        textAnswe4.setOnClickListener(this);
        textAnswe5.setOnClickListener(this);
        textAnswe6.setOnClickListener(this);
        textAnswe7.setOnClickListener(this);
        buttonContinue.setOnClickListener(this);
        imagBackDetail.setOnClickListener(this);
    }

    private void displayQuestion() {
        //TODO: Load question from database to Ui
    }

    @RequiresApi(api = VERSION_CODES.M)
    private void answer(TextView textView) {
        //TODO: Update background when click text.
        textView.setBackgroundColor(Objects.requireNonNull(getActivity()).getColor(R.color.colorPrimaryDark));
    }

    private void continue_question() {
        //TODO: Next question
    }
}
