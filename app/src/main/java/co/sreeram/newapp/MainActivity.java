package co.sreeram.newapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.Fragment;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment sub = new HomeFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content, sub).addToBackStack(null).commit();
                    return true;
                case R.id.navigation_dashboard:
                    DashFragment dash = new DashFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,dash).addToBackStack(null).commit();
                    return true;
                case R.id.navigation_notifications:
                    NotiFragment noti = new NotiFragment();
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.content,noti).addToBackStack(null).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HomeFragment sub = new HomeFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, sub).addToBackStack(null).commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
