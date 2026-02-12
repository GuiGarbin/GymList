package Controlers;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gymlist.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new HomeFragment())
                    .commit();
        }
        configBottomNavi();
    }

    public void configBottomNavi(){
        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(item-> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
                return true;
            } else if (id == R.id.nav_library) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LibraryFragment()).commit();
                return true;
            } else if (id == R.id.nav_cycle) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CycleProgressFragment()).commit();
                return true;
            } else if (id == R.id.nav_profile) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProfileFragment()).commit();
                return true;
            }

            return false;
        });
    }
}
