package com.example.synegymod4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView ticketInfo;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ticketInfo = findViewById(R.id.ticketInfo);

        Bundle bundle = getIntent().getExtras();

        user = (User) bundle.getSerializable(User.class.getSimpleName());

        ticketInfo.setText(user.toString());
    }

    public void onClickNewOrder(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}