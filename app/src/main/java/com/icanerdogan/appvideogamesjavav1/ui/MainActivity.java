package com.icanerdogan.appvideogamesjavav1.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationBarView;
import com.icanerdogan.appvideogamesjavav1.R;
import com.icanerdogan.appvideogamesjavav1.databinding.ActivityMainBinding;
import com.icanerdogan.appvideogamesjavav1.ui.favorite.FavoriteFragment;
import com.icanerdogan.appvideogamesjavav1.ui.home.HomeFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    FragmentManager fragmentManager = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideTitleBar();
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // HOME FRAGMENT
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, HomeFragment.class, null)
                .commit();


        binding.bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        fragmentManager.beginTransaction()
                                .replace(R.id.frame_layout, HomeFragment.class, null)
                                .commit();
                        break;
                    case R.id.navigation_favorite:
                        fragmentManager.beginTransaction()
                                .replace(R.id.frame_layout, FavoriteFragment.class, null)
                                .commit();
                        break;
                }
                return true;
            }
        }); {

        }
    }

    private void hideTitleBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                        View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

}