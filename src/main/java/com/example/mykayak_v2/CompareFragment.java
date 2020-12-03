package com.example.mykayak_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class CompareFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_fragment);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //find the menu.xml
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    //Options in the Toolbar
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_favorite:
                //Just putting a little toast
                Context context = getApplicationContext();
                String text = "Added to favorites";
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context, text, duration).show();
                return true;

            case R.id.action_settings:
                //Go to setting Activity
                Context context1 = getApplicationContext();
                Class destination1 = SettingsActivity.class;

                Intent intent = new Intent(context1, destination1);
                startActivity(intent);
                return true;

            case R.id.action_shopping:
                //Start Activity
                Context context3 = getApplicationContext();
                Class destination = ShoppingList.class;

                Intent intent3 = new Intent(context3, destination);
                startActivity(intent3);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Change between fragments
    //Video : https://www.youtube.com/watch?v=FF-e6CnBwYY&t=407s

    public void ChangeFragment(View view){

        Fragment fragment;
        if (view == findViewById(R.id.btnOne)){
            fragment = new FragmentOne();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();

        }
        if (view == findViewById(R.id.btnTwo)){
            fragment = new FragmentTwo();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.fragment_place, fragment);
            ft.commit();
        }
    }

    //For the Jackson Fragments WebSite and maps localization
    //Implicit intent
    public void onClickWWW(View view) {
        String action = Intent.ACTION_VIEW;
        Uri uri = Uri.parse("https://store.jacksonadventures.com/whitewater/jackson-kayaks/");

        Intent intent = new Intent(action, uri);
        startActivity(intent);
    }

    public void findShopJackson(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:35.87672884747622, -85.49939659155605"));
        startActivity(intent);
    }

}