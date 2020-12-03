package com.example.mykayak_v2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    //This activity is to change the settings of the app
    //I got help from the Udacity Shown in class

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);

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
    //Giving each option in the toolbar a specific action
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_settings:
                //Go to setting Activity
                Context context = getApplicationContext();
                Class destination = SettingsActivity.class;

                Intent intent = new Intent(context, destination);
                startActivity(intent);
                return true;

            case R.id.action_favorite:
                //Just putting a little toast
                Context context2 = getApplicationContext();
                String text = "Added to favorites";
                int duration = Toast.LENGTH_SHORT;
                Toast.makeText(context2, text, duration).show();
                return true;

            case R.id.action_shopping:
                //Start ShoppingList Activity
                Context context3 = getApplicationContext();
                Class destination1 = ShoppingList.class;

                Intent intent3 = new Intent(context3, destination1);
                startActivity(intent3);
                return true;

            case R.id.action_connection:

                //Start Connection Activity
                Context context4 = getApplicationContext();
                Class destination4 = FirebaseUIActivity.class;

                Intent intent4 = new Intent(context4, destination4);
                startActivity(intent4);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}