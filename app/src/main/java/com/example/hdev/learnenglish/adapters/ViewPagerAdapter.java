package com.example.hdev.learnenglish.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.example.hdev.learnenglish.fragments.OfferFragment;
import com.example.hdev.learnenglish.fragments.TrainingFragment;
import com.example.hdev.learnenglish.fragments.GrammarFragment;
import com.example.hdev.learnenglish.fragments.VocabularyFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(final FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(final int position) {
        switch (position) {
            case 0:
                return new OfferFragment();
            case 1:
                return new TrainingFragment();
            case 2:
                return new GrammarFragment();
            case 3:
                return new VocabularyFragment();
        }
        return null;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        return (Fragment) super.instantiateItem(container, position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(final int position) {
        switch (position){
            case 0: return "Đề xuất";
            case 1: return "Cần luyện";
            case 2: return "Ngữ pháp";
            case 3: return "Từ vựng";
        }
        return super.getPageTitle(position);
    }
}
