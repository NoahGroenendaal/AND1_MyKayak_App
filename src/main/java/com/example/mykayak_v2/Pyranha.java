package com.example.mykayak_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pyranha extends AppCompatActivity {

    //This is the page of Pyranha Kayaks
    //In this page we can get Live Data that shows the different kayaks available.
    //Nonetheless I tried for many hours to implement it with an API and a JSON file
    //I build an own Mocky, thanks to Mocky.io
    //The parts that are in comment are my attemps to insert the API message into the Live Data TextView

    //View Model
    PyranhaViewModel viewModel;
    TextView textView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pyranha);
        textView = findViewById(R.id.textView);
        progressBar = findViewById(R.id.progessBar);

        //View Model
        viewModel = new ViewModelProvider(this).get(PyranhaViewModel.class);
        viewModel.getMessage().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String message) {
                        textView.setText(message);
                    }
        });
        viewModel.isLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                int visibility = isLoading ? View.VISIBLE : View.INVISIBLE;
                progressBar.setVisibility(visibility);
            }
        });

        /*viewModel.getApimessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String apimessage) {
                textView.setText(apimessage);
            }
        });*/


        //Toolbar
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /*
    //API
    public void updateKayak(View view){
        viewModel.updateKayak(textView.getText().toString());
    }*/

    //find the menu.xml
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    //Giving each option in the toolbar a specific action
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

    //View Model
    public void retrieveDataFromInternet(View view) {
        viewModel.retrieveData();
    }


    //Go on the internet
    public void onClickWeb(View view) {
        String action = Intent.ACTION_VIEW;
        Uri uri = Uri.parse("https://www.pyranha.com/");

        Intent intent = new Intent(action, uri);
        startActivity(intent);
    }
    //Go on google maps to show the Pyranha Shop
    public void findShop(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:53.31251300980919, -2.6570745020860014"));
        startActivity(intent);
    }
    public void onClickGeo(View view) {
        findShop(view);
    }
}