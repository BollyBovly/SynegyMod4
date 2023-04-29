package com.example.synegymod4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private EditText nameId;
    private EditText departPoint;
    private EditText arrivePoint;
    private EditText timeDepart;
    private EditText timeArrive;
    private TextView ticketPrice;
    private Button button;

    private String nameIdStr;
    private String departPointStr;
    private String arrivePointStr;
    private String timeDepartStr;
    private String timeArriveStr;
    private String ticketPriceStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameId = findViewById(R.id.nameId);
        departPoint = findViewById(R.id.departPoint);
        arrivePoint = findViewById(R.id.arrivePoint);
        timeDepart = findViewById(R.id.timeDepart);
        timeArrive = findViewById(R.id.timeArrive);
        ticketPrice = findViewById(R.id.ticketPrice);
        button = findViewById(R.id.button);

        ticketPrice.setText("12 вечно золотых");


    }
    public void onClickTicket(View view) {
        nameIdStr = nameId.getText().toString();
        departPointStr = departPoint.getText().toString();
        arrivePointStr = arrivePoint.getText().toString();
        timeDepartStr = timeDepart.getText().toString();
        timeArriveStr = timeArrive.getText().toString();
        ticketPriceStr = ticketPrice.getText().toString();

        User user = new User(nameIdStr, departPointStr, arrivePointStr, timeDepartStr, timeArriveStr, ticketPrice.getText().toString());

        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        intent.putExtra(User.class.getSimpleName(), user);
        startActivity(intent);
    }
}