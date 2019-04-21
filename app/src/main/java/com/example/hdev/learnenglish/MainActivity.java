package com.example.hdev.learnenglish;

import android.annotation.SuppressLint;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.example.hdev.learnenglish.adapters.ViewPagerAdapter;
import com.example.hdev.learnenglish.fragments.VocabularyFragment;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    private TabLayout mTabLayout;

    private ViewPager mViewPager;

    private ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

    @RequiresApi(api = VERSION_CODES.KITKAT)
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindingView();
        initToolbar();
        initViewPager();
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuShowList: {
                VocabularyFragment vocabularyFragment = (VocabularyFragment) adapter.instantiateItem(mViewPager, 3);
                vocabularyFragment.displayTopics(Constants.DISPLAY_LIST);
            }

            case R.id.menuShowGrid: {
                VocabularyFragment vocabularyFragment = (VocabularyFragment) adapter.instantiateItem(mViewPager, 3);
                vocabularyFragment.displayTopics(Constants.DISPLAY_GRID);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void bindingView() {
        mToolbar = findViewById(R.id.toolbar);
        mTabLayout = findViewById(R.id.tabLayout);
        mViewPager = findViewById(R.id.view_pager);
    }

    @RequiresApi(api = VERSION_CODES.KITKAT)
    private void initToolbar() {
        setSupportActionBar(mToolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setTitle(R.string.title_main);
        mToolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(MainActivity.this, "Back", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @RequiresApi(api = VERSION_CODES.KITKAT)
    private void initViewPager() {
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        Objects.requireNonNull(mTabLayout.getTabAt(0)).setIcon(R.drawable.ic_star);
        Objects.requireNonNull(mTabLayout.getTabAt(1)).setIcon(R.drawable.ic_file);
        Objects.requireNonNull(mTabLayout.getTabAt(2)).setIcon(R.drawable.ic_grammar);
        Objects.requireNonNull(mTabLayout.getTabAt(3)).setIcon(R.drawable.ic_vocabulary);
    }
}
