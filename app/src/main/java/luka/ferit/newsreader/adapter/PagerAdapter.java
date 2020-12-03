package luka.ferit.newsreader.adapter;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import luka.ferit.newsreader.fragment.PagerFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        PagerFragment pagerFragment = new PagerFragment();
        return pagerFragment;
    }

    @Override
    public int getCount() {
        return 10;
    }
}
