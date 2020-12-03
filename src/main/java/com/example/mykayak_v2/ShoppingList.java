package com.example.mykayak_v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends AppCompatActivity {

    //In this activity you can make a shopping list using Shared preferences / Room and Dao

    TextView textViewExplain;
    EditText editText;
    TextView textViewMemo;
    SharedPreferences preferences;
    Button btnEnter;
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        textViewExplain = findViewById(R.id.tvExplain);
        textViewMemo = findViewById(R.id.tvMemo);
        editText = findViewById(R.id.etIpnut);
        btnEnter = findViewById(R.id.btnEnter);
        preferences = getSharedPreferences("prefs", MODE_PRIVATE);

        //Toolbar
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //ViewModel DAO
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                if (!notes.isEmpty()) {
                    textViewMemo.setText("");
                    for (Note n : notes) {
                        textViewMemo.append(n.getTitle() + "\n");
                    }
                } else {
                    textViewMemo.setText("Empty");
                }
            }
        });
    }

    //DAO Saving Notes && Deleting Notes
    public void saveNote(View v) {
        noteViewModel.insert(new Note(editText.getText().toString(), "description", 1));
    }

    public void deleteAllNotes(View v) {
        noteViewModel.deleteAllNotes();
    }

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
                //Start ShoppingList Activity
                Context context3 = getApplicationContext();
                Class destination3 = ShoppingList.class;

                Intent intent3 = new Intent(context3, destination3);
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