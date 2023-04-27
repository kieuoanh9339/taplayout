package com.oanhkieu.th2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TableLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.oanhkieu.th2.fragment.FragmentAdapter;
import com.oanhkieu.th2.fragment.InfoFragment;
import com.oanhkieu.th2.fragment.ListFragment;
import com.oanhkieu.th2.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    private TabLayout tab;

    private ViewPager cv;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNav);
        tab= findViewById(R.id.tab);
        cv= findViewById(R.id.vp);
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), 3);
        cv.setAdapter(adapter);
        tab.setupWithViewPager(cv);


        setupBottomNav();
    }
    private void setupBottomNav(){
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.frgList:
                        cv.setCurrentItem(0);
                        break;
                    case R.id.frgInfo :
//                        getSupportFragmentManager().beginTransaction().replace(R.id.vp, new InfoFragment(),null).commit();
                        cv.setCurrentItem(1);
                        break;
                    case R.id.frgSearch://khong an duoc check messss
//                        getSupportFragmentManager().beginTransaction().replace(R.id.vp, new SearchFragment(),null).commit();
                        cv.setCurrentItem(2);
                        break;
                }
                return true;
            }

        });
    }
}