package com.example.synegymod4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {
    List<Animal> animals = new ArrayList<Animal>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setInitialDate();

        RecyclerView recyclerView = findViewById(R.id.list_animal);

        AnimalAdapter adapter = new AnimalAdapter(this, animals);
        recyclerView.setAdapter(adapter);
    }

    private void setInitialDate() {
        animals.add( new Animal("Бизон", "Вид парнокопытных млекопитающих из трибы быков семейства полорогих. Очень близок к зубру",
                R.drawable.bizon, "Численность средняя"));
        animals.add( new Animal("Грифовая черепаха", "Вид черепах в роде Macrochelys ",
                R.drawable.grif, "Численность маленькая"));
        animals.add( new Animal("Койот", "Хищное млекопитающее семейства псовых. Название происходит от ацтекского coyotl — «божественная собака» ",
                R.drawable.koat, "Численность большая"));
        animals.add( new Animal("Техасский гремучник", "Ядовитая змея подсемейства ямкоголовых семейства гадюковых",
                R.drawable.texassnake, "Численность большая"));

    }
}