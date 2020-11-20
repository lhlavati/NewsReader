package luka.ferit.newsreader.view;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import luka.ferit.newsreader.R;

public class ViewPagerActivity extends FragmentActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.viewpager);

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new luka.ferit.newsreader.adapter.PagerAdapter(getSupportFragmentManager(), 1);
        viewPager.setAdapter(pagerAdapter);

        onBackPressed();

    }
}
