package com.example.d2d;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        loadFragment(new HomeFragment());
    }

    private boolean loadFragment(Fragment fragment)
    {
        if(fragment != null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {
        Fragment fragment = null;

        switch (menuItem.getItemId())
        {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_exercise:
                fragment = new ExcerciseFragment();
                break;
            case R.id.navigation_nutrition:
                fragment = new NutritionFragment();
                break;
            case R.id.navigation_settings:
                fragment = new SettingsFragment();
                break;
        }

        return loadFragment(fragment);
    }
}
