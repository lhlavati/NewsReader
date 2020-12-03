package luka.ferit.newsreader.view;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import luka.ferit.newsreader.R;

public class ViewPagerActivity extends FragmentActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    int pos;
    String title;
    String desc;
    String url;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager);

        Bundle extras = getIntent().getExtras();
        pos = extras.getInt("pos");
        title = extras.getString("title");
        desc = extras.getString("desc");
        url = extras.getString("image");

        viewPager = findViewById(R.id.pager);
        pagerAdapter = new luka.ferit.newsreader.adapter.PagerAdapter(getSupportFragmentManager(), 1);
        viewPager.setAdapter(pagerAdapter);

    }
}
