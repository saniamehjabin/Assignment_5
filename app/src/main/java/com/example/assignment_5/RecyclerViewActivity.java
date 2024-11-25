package com.example.assignment_5;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String[] title = getResources().getStringArray(R.array.animals);
        String[] subtitle ={
                "Playful and Curious Companion","Nature's Aquatic Acrobat",
                "Tiny but Mighty Adventurer","Nighttime Forager Extraordinaire",
                "Gentle Climber of the Himalayas", "Vigilant Desert Dweller","Sub Title 7",
                "Sub Title 8","Sub Title 9",
                "Sub Title 10",
        };
        Integer[] imgid= {R.drawable.ferret, R.drawable.otter, R.drawable.hamster, R.drawable.raccoon,
                R.drawable.red_panda, R.drawable.meerkat};
        ArrayList<Model> data = new ArrayList<>();

        for (int i = 0; i<title.length; i++){
            Model obj = new Model();
            obj.setTitle(title[i]);
            obj.setSubtitle(subtitle[i]);
            obj.setImageId(imgid[i]);
            data.add(obj);
        }

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(data, getApplicationContext());

        recyclerView.setAdapter(adapter);
    }
}