package com.example.synegymod4.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.synegymod4.R;
import com.example.synegymod4.viewmodel.DatabaseHelper;

public class UpdateActivity extends AppCompatActivity {
    private EditText title, description;
    private Button updateNote, deleteNote;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        updateNote = findViewById(R.id.update_note);
        deleteNote = findViewById(R.id.delete_note);

        Intent intent = getIntent();
        title.setText(intent.getStringExtra("title"));
        description.setText(intent.getStringExtra("description"));
        id = intent.getStringExtra("id");

        updateNote.setOnClickListener(listener);
        deleteNote.setOnClickListener(listener);

    }

    public View.OnClickListener listener = new View.OnClickListener() {
        public void onClick(View view) {
            if (!TextUtils.isEmpty(title.getText().toString()) && !TextUtils.isEmpty(description.getText().toString())) {
                DatabaseHelper db = new DatabaseHelper(UpdateActivity.this);
                switch (view.getId()) {
                    case R.id.update_note:
                        db.updateNote(title.getText().toString(), description.getText().toString(), id);
                        break;
                    case R.id.delete_note:
                        db.deleteSingleItems(id);
                        break;
                }
                startActivity(new Intent(UpdateActivity.this, SecnodActivity.class));
            } else {
                Toast.makeText(UpdateActivity.this, "Изменений не внесено", Toast.LENGTH_SHORT).show();
            }
        }
    };
}