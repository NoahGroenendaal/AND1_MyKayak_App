package com.example.mykayak_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class KayakPage extends AppCompatActivity implements KayakAdapter.OnListItemClickListener {

    //This is the second Page, A RecyclerView of a list with different Kayak brands

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayak_page);
        recyclerView = findViewById(R.id.rv);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        //Toolbar
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //RecyclerViews

        List<Kayaks> kayaks = new ArrayList<>();

        kayaks.add(new Kayaks("Pyranha", R.drawable.pyranhalogo));
        kayaks.add(new Kayaks("Jackson Kayaks", R.drawable.jacksonkayakslogo));
        kayaks.add(new Kayaks("Dagger", R.drawable.daggerlogo));
        kayaks.add(new Kayaks("Liquidlogic", R.drawable.liquidlogiclogo));
        kayaks.add(new Kayaks("Wave Sports", R.drawable.mavesportslogo));
        kayaks.add(new Kayaks("Waka Kayaks", R.drawable.wakalogo));
        kayaks.add(new Kayaks("Exo Kayaks", R.drawable.exologo));
        kayaks.add(new Kayaks("Zet Kayaks", R.drawable.zetkayakslogo));
        kayaks.add(new Kayaks("Perception", R.drawable.perceptionlogo));
        kayaks.add(new Kayaks("Fluid Kayaks", R.drawable.fluidlogo));

        KayakAdapter adapter = new KayakAdapter(kayaks, this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onClick(int position) {

        //Just to show on which position the recyclerview is
        Toast.makeText(this, "Position" + position, Toast.LENGTH_SHORT).show();

        //To switch to a new Activity
        switch (position) {

            case 0 :
                //Start Activity Pyranha Kayaks
                Context context = getApplicationContext();
                Class destination = Pyranha.class;

                Intent intent = new Intent(context, destination);
                startActivity(intent);
                break;

            case 1 :
                //Start Activity Jackson Kayaks
                Context context1 = getApplicationContext();
                Class destination1 = CompareFragment.class;

                Intent intent1 = new Intent(context1, destination1);
                startActivity(intent1);
                break;
        }
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
}