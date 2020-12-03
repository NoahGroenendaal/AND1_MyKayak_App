package com.example.mykayak_v2;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
====================================================================================================
= Author : Noah Groenendaal 032106                                                                 =
= Date : 03/12/2020                                                                                =
= Problems encountered :                                                                           =
=       - API :                                                                                    =
=           Managed everything it seems.                                                           =
=           But i dont know how to display the message.                                            =
=       - I tried the Live data message display from lesson 7, didn't work out                     =
=           I tried for multiple hours to implement the API into the LiveData message display.     =
=                                                                                                  =
= DISCLAMER :                                                                                      =
=       - The app is not perfect.                                                                  =
=         There are still some mistakes and it isn't the prettiest visually.                       =
=         But I took me a lot of time and effort to make.                                          =
=         I learned a lot and I am happy about the result                                          =
====================================================================================================
 */

public class MainActivity extends AppCompatActivity {

    Button startButton;
    TextView textView;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);
        textView = findViewById(R.drawable.fotokayak);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }


    //find the menu.xml for the Toolbar
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
                //Start Shopping Activity
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

    //Start KayakPage Activity
    public void startButton(View view) {
        Context context = getApplicationContext();
        Class destination = KayakPage.class;

        Intent intent = new Intent(context, destination);
        startActivity(intent);
    }

}