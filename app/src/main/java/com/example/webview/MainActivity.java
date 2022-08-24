package com.example.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimalAdapter.MyClickInterface {


    RecyclerView recyclerView;
    ArrayList<Animal> animals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        animals = new ArrayList<>();
        animals.add(new Animal("Dolphin", R.drawable.dolphin));

        AnimalAdapter animalAdapter = new AnimalAdapter(animals, this,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(animalAdapter);

    }

    @Override
    public void onItemClick(int positionOfTheAnimal) {
        Toast.makeText(this,"Clicked " + animals.get(positionOfTheAnimal).getName(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,AnimalInfo.class);
        intent.putExtra("image",animals.get(positionOfTheAnimal).getImage());
        intent.putExtra("name",animals.get(positionOfTheAnimal).getName());
        startActivity(intent);

    }
}