package com.example.synegymod4.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.synegymod4.R;
import com.example.synegymod4.model.Notebook;
import com.example.synegymod4.viewmodel.Adapter;
import com.example.synegymod4.viewmodel.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class SecnodActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FloatingActionButton fabAdd;
    private ImageButton imageButton;

    private List<Notebook> notesList;

    private DatabaseHelper database;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secnod);

        recyclerView = findViewById(R.id.recycler_list);
        fabAdd = findViewById(R.id.fabAdd);
        imageButton = findViewById(R.id.imageButtonBin);

        notesList = new ArrayList<>();
        database = new DatabaseHelper(this);

        fetchAllNotes();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, SecnodActivity.this, notesList);
        recyclerView.setAdapter(adapter);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SecnodActivity.this, AddNotesActivity.class));
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper database = new DatabaseHelper(SecnodActivity.this);
                database.deleteNote();
                finish();
            }
        });
    }

    public void fetchAllNotes(){
        Cursor cursor = database.readNotes();

        if (cursor.getCount() == 0) {
            Toast.makeText(this, "Заметок нет", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                notesList.add(new Notebook(cursor.getString(0), cursor.getString(1), cursor.getString(2)));
            }
        }
    }
}