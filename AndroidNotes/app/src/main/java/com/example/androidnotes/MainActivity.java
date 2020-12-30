package com.example.androidnotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tvShow,tvShowContent;
    ArrayList<Notes> listNote;
    AndroidNotesAdapter androidNotesAdapter;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvShow = findViewById(R.id.tvShow);
        tvShowContent = findViewById(R.id.tvShowContent);
        recyclerView = findViewById(R.id.lvNote);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        listNote =new ArrayList<>();
        //Tu nhap Danh Sach tai day
        listNote.add(new Notes("TD1 Lorem ipsum dolor sit amet, consectetuer adipiscing elit.", "12-12-2020", " Donec odio. Quisque volutpat mattis eros. Nullam malesuada erat ut turpis. Suspendisse urna nibh, viverra non, semper suscipit, posuere a, pede."));
        listNote.add(new Notes("TD2", "13-12-2020", "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis."));
        listNote.add(new Notes("TD3", "14-12-2020", "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis."));
        listNote.add(new Notes("TD4", "15-12-2020", "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis."));
        listNote.add(new Notes("TD5", "16-12-2020", "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis."));
        listNote.add(new Notes("TD6", "17-12-2020", "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis."));
        listNote.add(new Notes("TD7", "18-12-2020", "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis."));
        listNote.add(new Notes("TD8", "19-12-2020", "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis."));
        listNote.add(new Notes("TD9", "20-12-2020", "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis."));
        listNote.add(new Notes("TD10", "21-12-2020", "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis."));
        listNote.add(new Notes("TD11", "22-12-2020", "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis."));
        listNote.add(new Notes("TD12", "23-12-2020", "Donec nec justo eget felis facilisis fermentum. Aliquam porttitor mauris sit amet orci. Aenean dignissim pellentesque felis."));


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");

        tvShow.setText(title);
        tvShowContent.setText(content);
        recyclerView.setLayoutManager(layoutManager);
        androidNotesAdapter = new AndroidNotesAdapter(MainActivity.this, R.layout.list_item, listNote);
        recyclerView.setAdapter(androidNotesAdapter);
        androidNotesAdapter.notifyDataSetChanged();
    }
}